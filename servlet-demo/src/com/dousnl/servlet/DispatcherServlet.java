package com.dousnl.servlet;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dousnl.annotation.Controller;
import com.dousnl.annotation.Quatifier;
import com.dousnl.annotation.RequestMapping;
import com.dousnl.annotation.Service;
import com.dousnl.controller.SpringMvcController;
import com.sun.xml.internal.ws.util.StringUtils;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<String> packageNames = new ArrayList<String>();
	// 所有类的实例，key是注解的value,value是所有类的实例
	Map<String, Object> instanceMap = new HashMap<String, Object>();
	Map<String, Object> handerMap = new HashMap<String, Object>();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// 包扫描,获取包中的文件
		scanPackage("com.dousnl");
		System.out.println("****************filterAndInstance*****************");
		try {
			filterAndInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 建立映射关系
		handerMap();
		// 实现注入
		ioc();
	}
	
	private String replaceTo(String scanPackage) {
		return scanPackage.replaceAll("\\.", "/");
	}
	/**
	 * 扫描包下的所有文件
	 * 
	 * @param scanPackage
	 */
	private void scanPackage(String scanPackage) {
		// 将所有的.转义获取对应的路径
		URL url = this.getClass().getClassLoader().getResource("/"+replaceTo(scanPackage));
		String pathfile = url.getFile();
		//System.out.println("pathfile:"+pathfile);
		File file=new File(pathfile);
		String[] filelist = file.list();
		for(String path:filelist){
			//System.out.println("path:"+path);
			File simplefile=new File(pathfile+path);
			if(simplefile.isDirectory()){
				//System.out.println("子文件路径："+scanPackage + "." + simplefile.getName());
				scanPackage(scanPackage + "." +simplefile.getName());
			}else{
				//System.out.println("包路径新增:"+scanPackage + "." + simplefile.getName());
				packageNames.add(scanPackage + "." + simplefile.getName());
			}
		}
	}
	

	private void filterAndInstance() throws Exception {
		if (packageNames.size() <= 0) {
			return;
		}
		for(String className:packageNames){
			//System.err.println("className:"+className);
			Class<?> name = Class.forName(className.replace(".class", "").trim());
			if (name.isAnnotationPresent(Controller.class)) {
				Object instance = name.newInstance();
				Controller controller = name.getAnnotation(Controller.class);
				String key = controller.value();
				//System.out.println("key:"+key);
				instanceMap.put(key, instance);
			}else if(name.isAnnotationPresent(Service.class)){
				Object instance = name.newInstance();
				Service service = name.getAnnotation(Service.class);
				String key = service.value();
				if(key==null || "".equals(key)){
					String classname = name.getSimpleName();
					String newkey=classname.substring(0, 1).toLowerCase()+classname.substring(1);
					instanceMap.put(newkey, instance);
				}else{
					instanceMap.put(key, instance);
				}
			}else {
				//System.out.println("包名不包含controller,service==>"+name.getName());
				continue;
			}
		}
		for (Map.Entry<String, Object> entry : instanceMap.entrySet()) {
			System.out.println("filterAndInstance-----entry.getKey():"+entry.getKey()+"--entry.getValue():"+entry.getValue()+"\t");
		}
	}
	/**
	 * 建立映射关系
	 */
	private void handerMap() {
		if (instanceMap.size() <= 0)
			return;
		for (Map.Entry<String, Object> entry : instanceMap.entrySet()) {
			if (entry.getValue().getClass().isAnnotationPresent(Controller.class)) {
				Controller controller = (Controller) entry.getValue().getClass().getAnnotation(Controller.class);
				String ctvalue = controller.value();
				Method[] methods = entry.getValue().getClass().getMethods();
				for (Method method : methods) {
					if (method.isAnnotationPresent(RequestMapping.class)) {
						RequestMapping rm = (RequestMapping) method.getAnnotation(RequestMapping.class);
						String rmvalue = rm.value();
						System.out.println("haderMap.put==>"+"/" + ctvalue + "/" + rmvalue);
						handerMap.put("/" + ctvalue + "/" + rmvalue, method);
					} else {
						continue;
					}
				}
			} else {
				continue;
			}
 
		}
	}
	
	private void ioc() {
		if (instanceMap.isEmpty())
			return;
		for (Map.Entry<String, Object> entry : instanceMap.entrySet()) {
			if (entry.getValue().getClass().isAnnotationPresent(Controller.class)) {
				// 拿到里面的所有属性
				Field fields[] = entry.getValue().getClass().getDeclaredFields();
				int i=0;
				for (Field field : fields) {
					field.setAccessible(true);// 可访问私有属性
					if (field.isAnnotationPresent(Quatifier.class));
					Quatifier quatifier = field.getAnnotation(Quatifier.class);
					String value = quatifier.value();
					field.setAccessible(true);
					try {
						System.out.println("entry.getValue():"+entry.getValue()+"\t"+i);
						if(value==null || "".equals(value)){
							String classname = field.getType().getSimpleName();
							if(field.getType().isInterface()){
							}
							System.out.println("value:"+classname.substring(0, 1).toLowerCase()+classname.substring(1)+"\t"+i);
							field.set(entry.getValue(), instanceMap.get(classname.substring(0, 1).toLowerCase()+classname.substring(1)));
							System.out.println("class:"+instanceMap.get(classname.substring(0, 1).toLowerCase()+classname.substring(1))+"\t"+i);
						}else{
							field.set(entry.getValue(), instanceMap.get(value));
						}
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
					i++;
				}
			}else {
				continue;
			}
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		String context = request.getContextPath();
		String path = url.replace(context, "");
		Method method = (Method) handerMap.get(path);
		SpringMvcController controller = (SpringMvcController) instanceMap.get(path.split("/")[1]);
		try {
			method.invoke(controller, new Object[] { request, response, null });
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

}
