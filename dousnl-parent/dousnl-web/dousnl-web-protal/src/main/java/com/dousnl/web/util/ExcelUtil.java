package com.dousnl.web.util;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jxls.transformer.XLSTransformer;

public class ExcelUtil {
	/** 
     * ����ģ������Excel�ļ�. 
     * @param templateFileName ģ���ļ�. 
     * @param list ģ���д�ŵ�����. 
     * @param resultFileName ���ɵ��ļ�. 
     */  
	public void createExcel(String templateFileName,List<?> list,String resultFileName){
		//����XLSTransformer����
		XLSTransformer transformer=new XLSTransformer();
		//��ȡjava��Ŀ������·�� 
		URL url=this.getClass().getClassLoader().getResource("");
		//�õ�ģ���ļ�·��
		String srcFilePath=url.getPath()+templateFileName;
		Map<String,Object> beanParams = new HashMap<String,Object>();
		beanParams.put("list", list);
		String destFilePath = url.getPath() + resultFileName; 
		try {
			//����Excel�ļ�
			transformer.transformXLS(srcFilePath, beanParams, destFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
