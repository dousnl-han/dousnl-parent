package com.dousnl.webservice.axisclient;

import com.dousnl.webservice.axisclient.WeatherWSStub.ArrayOfString;
import com.dousnl.webservice.axisclient.WeatherWSStub.GetSupportCityStringResponse;
import com.dousnl.webservice.axisclient.WeatherWSStub.GetWeatherResponse;

public class AxisWeartherClientTest {

	/*public static void main(String[] args) throws Exception {
		
		WeatherWSStub stub=new WeatherWSStub();
		
		WeatherWSStub.GetSupportCityString cityString=new WeatherWSStub.GetSupportCityString();
		cityString.setTheRegionCode("上海");
		WeatherWSStub.GetWeather getWeather4=new WeatherWSStub.GetWeather();
		getWeather4.setTheCityCode("上海");
		*//**
		 * 获取天气
		 *//*
		System.out.println("====================获取天气====================");
		GetWeatherResponse weather = stub.getWeather(getWeather4);
		ArrayOfString getWeatherResult = weather.getGetWeatherResult();
		String[] string2 = getWeatherResult.getString();
		for(String s:string2){
			System.out.println(s);
		}
		*//**
		 * 获取区代码
		 *//*
		System.out.println("====================获取区代码====================");
		GetSupportCityStringResponse supportCityString = stub.getSupportCityString(cityString);
		ArrayOfString getSupportCityStringResult = supportCityString.getGetSupportCityStringResult();
		String[] string = getSupportCityStringResult.getString();
		for(String s:string){
			System.out.println(s);
		}
	}*/
}
