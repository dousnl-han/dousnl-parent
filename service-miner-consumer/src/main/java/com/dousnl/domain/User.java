package com.dousnl.domain;

import java.util.Date;

public class User {
	private String name;
	private int age;
    private Date brith;
    private double money;

	public User() {
		super();
	}

	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
	
}
