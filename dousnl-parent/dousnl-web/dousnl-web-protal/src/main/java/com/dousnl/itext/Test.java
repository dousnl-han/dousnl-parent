package com.dousnl.itext;

public class Test {

	public static void main(String[] args) {
		WeekDay day=WeekDay.mon;
		Day d=Day.MON;
		System.out.println("==="+d);
		System.out.println("==="+d.name());
		System.out.println("==="+d.ordinal());
		System.out.println("==="+Day.valueOf("MON"));
	}
	
	public enum Day{
		MON,TES(1),WED;
		
		private Day() {System.out.println("first");}
		private Day(int day) {System.out.println("second");}
	}
}
