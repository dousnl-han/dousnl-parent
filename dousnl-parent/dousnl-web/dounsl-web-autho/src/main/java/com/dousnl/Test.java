package com.dousnl;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static Map<String,Object> map=new HashMap<>();

    public static void add(String key,String...fileds){
        map.put(key,fileds);
    }
    public static void main(String[] args) {
        String  key="key";
        String value="value_1.keyword";
        String value2="value_2";
        add(key,value,value2);
        System.out.println(JSON.toJSONString(map));
    }
}
