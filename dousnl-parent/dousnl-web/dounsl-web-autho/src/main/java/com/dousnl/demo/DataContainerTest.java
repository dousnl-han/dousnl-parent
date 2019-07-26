package com.dousnl.demo;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

@Slf4j
public class DataContainerTest {

    public static void main(String[] args) {
        DataContainer<String> hod_1 = new DataContainer<>("hod_1");
        DataContainer<Integer> hod_2 = new DataContainer<>(2);
        DataContainer<User> hod_3 = new DataContainer<>(new User("hod_3", 20));
        DataContainer.addData(hod_1.getClass().getName() + 1, hod_1.getData());
        DataContainer.addData(hod_2.getClass().getName() + 2, hod_2.getData());
        DataContainer.addData(hod_3.getClass().getName() + 3, hod_3.getData());
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("str1");
        arrayList.add("atr1");
        arrayList.stream().filter(e -> e.startsWith("a")).forEach(e -> {
            log.info(e.toString());
        });
        DataContainer dataContainer = hod_1.getDataContainer();
        Gson gson1 = new Gson();
        //System.out.println(gson1.toJson(dataContainer));
        System.out.println(JSON.toJSONString(dataContainer));
        Type type=new TypeToken<User>(){}.getType();
        log.info(JSON.toJSONString(DataContainer.getContainMap()));
    }
}
