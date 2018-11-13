package com.dousnl.domain;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
    private Integer id;

    private String name;

    private Date brith;
    
    private double money;
    
    private int age;
    
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public Date getBrith() {
		return brith;
	}

	public void setBrith(Date brith) {
		this.brith = brith;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}