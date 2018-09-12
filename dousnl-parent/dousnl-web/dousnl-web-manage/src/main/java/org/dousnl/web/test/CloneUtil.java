package org.dousnl.web.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/** 
 * ��������Row֮������ݣ����署һ�������ݵ�Row����������ѡ���Եĸ��Ƶ�һ���յ�Row�У�ͨ�����Ե�set��get���� <br /> 
 * desRow��srcRow��������һ���� <br /> 
 * ֻ�ܸ���RowImpl���͵Ķ���<br /> 
 * ע�⣺��λ��VO��Attribute��ǩ����б�Ϊ׼��desRow�д��ڵ�������srcRow�б�����ڣ� 
 * ������needlessColumn_List����srcRow�в����ڵ����� 
 */
public class CloneUtil {
	private Object desRow; // Ŀ��Row  
    private Object srcRow; // ԴRow  
    private List<String> needlessColumn_List; // ��Ҫ���������Ե�List  
  
    public CloneUtil(Object desRow, Object srcRow,  
            List<String> needlessColumn_List) {  
        this.desRow = desRow;  
        this.srcRow = srcRow;  
        this.needlessColumn_List = needlessColumn_List;  
    }  
  
    /** 
     *������ 
     *  
     * @throws Exception 
     */  
    public void deepClone() {  
        Method setMethod = null; // ԴBean�е����Ե�set����  
        Method getMethod = null; // ԴBean�е����Ե�get����  
  
        Class desRowClass = desRow.getClass(); // �õ�desRow��Class  
        Method[] publicMethods = desRowClass.getMethods(); // ����Public��Χ�ķ����������Ӹ���̳еĺʹӽӿ�ʵ�ֵĹ�������  
        Method[] exceptedSuperMethods = desRowClass.getDeclaredMethods(); // ���ඨ������з�Χ�ķ������������Ӹ���̳еĺʹӽӿ�ʵ�ֵķ���  
        List<Method> neededMethodsList = new ArrayList<Method>(); // ����Bean�ж�Ӧ���Եķ�����List  
        fetchNeededMethods(publicMethods,exceptedSuperMethods,neededMethodsList); // ֻ��Bean�����Ե�set��������neededMethodsList���Ա㴦��  
        try {  
            for (Method neededMethod : neededMethodsList) { // ѭ�������desRow��Class��Ӧ�����з���  
                String neededMethodName = neededMethod.getName();  
                // ��������Ҫ���Ƶ�����  
                boolean inList = false;  
                if (this.needlessColumn_List != null  && !needlessColumn_List.isEmpty()) {  
                    inList = checkNeedlessColumn(neededMethodName); // ��鲻��Ҫ���Ƶ�����  
                    if (inList == false) { // �����ǰ�������ƴ�����needlessColumn_List�У�������  
                        continue;  
                    }  
                }  
                // �õ�ԴBean�е����Ե�set����  
                setMethod = srcRow.getClass().getMethod(neededMethodName,neededMethod.getParameterTypes());  
                // �õ�ԴBean�е����Ե�get����  
                getMethod = srcRow.getClass().getMethod(convertName(setMethod.getName()), null);  
                Object item = getMethod.invoke(srcRow, null); // ִ��ԴBean��get�������õ�����ֵ  
                neededMethod.invoke(desRow, item); // ִ��Ŀ��Bean��set����  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    /** 
     *ֻ��VO�����Ե�set��������neededMethodsList���Ա㴦�� 
     * ��ΪpublicMethods��exceptedSuperMethods�п����кܶ಻��Ҫ���� 
     *  
     * @param publicMethods 
     * @param exceptedSuperMethods 
     * @param neededMethodsList 
     */  
    private void fetchNeededMethods(Method[] publicMethods, Method[] exceptedSuperMethods, List<Method> neededMethodsList) {  
        for (Method publicMethod : publicMethods) { // ����publicMethods  
            String publicMethodName = publicMethod.getName(); // publicMethods�е�ÿһ��������  
            if (publicMethodName.startsWith("set")) { // ֻ�����ԡ�set����ͷ�ķ���  
                for (Method exceptedSuperMethod : exceptedSuperMethods) { // ����methodsExceptSuper  
                    String exceptedSuperMethodName = exceptedSuperMethod.getName();  
                    if (publicMethodName.equals(exceptedSuperMethodName)) // ���publicMethodName��exceptedSuperMethodName���  
                        neededMethodsList.add(publicMethod); // �����������ķ��������List��  
                }  
            }  
        }  
    }  
  
    /** 
     *����needlessColumn_List�е���Ŀ 
     *  
     * @param methodName 
     *            desRow��Class���ԡ�set����ͷ�ķ��� 
     * @return ���methodName�����ڴ�List�� �򷵻�false 
     */  
    private boolean checkNeedlessColumn(String methodName) {  
        ListIterator<String> it = needlessColumn_List.listIterator();  
        while (it.hasNext()) {  
            String needlessColumn = it.next();  
            String uuidCName = "set" + needlessColumn;  
            if (uuidCName.equals(methodName)) {  
                needlessColumn_List.remove(needlessColumn);  
                return false;  
            }  
        }  
        return true;  
    }  
  
    /** 
     *��setXxx��������ת����getXxx�������� 
     *  
     * @param methodName 
     *            set��ͷ�ķ������� 
     * @return ��Ӧ��get���� 
     */  
    private String convertName(String methodName) {  
        if (methodName == null) {  
            return null;  
        }  
        String s = methodName.substring(3, methodName.length());  
        return "get" + s;  
    }  
  
}  
