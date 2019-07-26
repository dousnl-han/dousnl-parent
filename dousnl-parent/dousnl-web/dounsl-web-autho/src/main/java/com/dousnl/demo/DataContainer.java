package com.dousnl.demo;

import java.util.HashMap;
import java.util.Map;

public class DataContainer<T> implements DataContainerInterface{

    private static Map<String, Object> containMap = new HashMap<String, Object>();

    T data;

    public static <T> void  addData(String key , T t){
        containMap.put(key,t);
    }
    public T getData() {
        return data;
    }

    public DataContainer(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static Map getContainMap(){
        return containMap;
    }
}
