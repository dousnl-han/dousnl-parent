package com.dousnl.itext;

public abstract class WeekDay {

	public static final WeekDay sun=new WeekDay() {
		@Override
		public WeekDay nextDay() {
			return mon;
		}
	};
    public static final WeekDay mon=new WeekDay() {
		@Override
		public WeekDay nextDay() {
			return sun;
		}
	};
	
	public abstract WeekDay nextDay();
}
