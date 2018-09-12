package org.dousnl.api.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Fruit {
	private Integer id;
	private String name;
	private Double prace;
	@JSONField(format="yyyy-MM-dd")
	private Date creatTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrace() {
		return prace;
	}

	public void setPrace(Double prace) {
		this.prace = prace;
	}

	public Fruit() {
		super();
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
