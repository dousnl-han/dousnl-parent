package org.dousnl.test;

public class SystemOsName {

	public static void main(String[] args) {
		String osname=System.getProperty("os.name")+"_"+System.getProperty("os.arch")+"_"+System.getProperty("os.version");
        System.out.println(osname);
	}

}
