package com.dousnl.genericity;

public class TwoTuple<A,B> {
	
	private  A first;
	private  B second;
	
	public TwoTuple(A a, B b){
		this.first=a;
		this.second=b;
	};
	public String toString(){
		return "("+first+")";
	}
	

}
