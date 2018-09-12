package org.dousnl.util;

public class EnumUtil {
	
	public enum Type{
		/**
		 * 按钮
		 */
		button,
		/**
		 * 单选
		 */
		select,
		/**
		 * 复选框
		 */
		checkbox;
	}
	private int id;
	
    private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    

}
