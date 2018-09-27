package com.dousnl.thread.pool;

import java.util.concurrent.Callable;

public class RunAndResult implements Callable<String>{

	private int id;
	
	public RunAndResult(int id) {
		this.id=id;
	}
	@Override
	public String call() throws Exception {
		return "this is the result "+id;
	}

}

