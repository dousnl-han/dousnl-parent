package com.dousnl.spring.security.common;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class BaseResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	private Boolean success;
	
	private String code;
	
	private Object data;
	
	
	public BaseResponse(Object data) {
		this.data=data;
	}

	public BaseResponse(boolean success, String code, Object data) {
		super();
		this.success = success;
		this.code = code;
		this.data = data;
	}


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}

	
}
