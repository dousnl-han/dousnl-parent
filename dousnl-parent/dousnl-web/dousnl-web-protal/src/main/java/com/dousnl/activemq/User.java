package com.dousnl.activemq;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1035643076617159214L;
	private int id;
	private String name;
	private Date pridaty;
	private List<String> address;
	
	public User(){
	}
	public User(int id,String name,Date pridaty){
		this.id=id;
		this.name=name;
		this.pridaty=pridaty;
	}
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
	public Date getPridaty() {
		return pridaty;
	}
	public void setPridaty(Date pridaty) {
		this.pridaty = pridaty;
	}
	public List<String> getAddress() {
		return address;
	}
	public void setAddress(List<String> address) {
		this.address = address;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
