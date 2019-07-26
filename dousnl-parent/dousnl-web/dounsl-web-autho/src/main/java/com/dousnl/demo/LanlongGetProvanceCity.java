package com.dousnl.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Slf4j
public class LanlongGetProvanceCity {

    public static void main(String[] args) {
        // lat 31.2990170   纬度
        //log 121.3466440    经度
        //String add = LanlongGetProvanceCity.getAdd("121.3466440", "31.2990170");
        String add = LanlongGetProvanceCity.getAdd("113.631349", "34.753488");
        //String add1 = LanlongGetProvanceCity.getAdd("121.27 ", "31.38");
        //String s = LanlongGetProvanceCity.GetLocationMsg(31.2990170, 121.3466440);
        log.info(add);

    }

    private static String getAdd(String lon, String lat) {
        //lat 小  log  大
        //参数解释: 纬度,经度 type 001 (100代表道路，010代表POI，001代表门址，111可以同时显示前三项)
        //http://api.map.baidu.com/geocoder/v2/?ak=pmCgmADsAsD9rEXkqWNcTzjd&location=30.548397,104.04701&output=json&pois=1
        //String urlString = "http://gc.ditu.aliyun.com/regeocoding?l="+lat+","+lon+"&type=010";
        //wPPxsfCtNFm4PqEV68jbDdjP7U4twstj
        //pushL6wZbOCcT8jwAKjcSq2usdE6IlK5--个人app禁用
        //3Ykvw6Vtb1AqkXeIqh2wSzRVGZMTGUPH--个人app禁用
        String ak="FxXifvkVkZ8n0633gHZWmqO1iD5rcOLK";
        String urlString = "http://api.map.baidu.com/geocoder/v2/?ak="+ak+"&location="+lat+","+lon+"&output=json&pois=1";
        String res = "";
        try {
            URL url = new URL(urlString);
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                res += line+"\n";
            }
            in.close();
            //解析结果
            JSONObject jsonObject = JSONObject.parseObject(res);
            JSONObject result = jsonObject.getJSONObject("result");
            JSONObject addressComponent = result.getJSONObject("addressComponent");
            String province = addressComponent.getString("province");
            String city = addressComponent.getString("city");
            String district = addressComponent.getString("district");

            //JSONArray jsonArray=jsonObject.getJSONArray("addrList");
            //JSONObject jsadd = jsonArray.getJSONObject(0);
            //res = jsadd.getString("admName");//返回省市区
            res=province+":"+city+":"+district;
        } catch (Exception e) {
            log.error("获取地址信息异常{}",e.getMessage());
            return null;
        }
        return res;
    }

    public static String GetLocationMsg(double latitude,double longitude){

        String message = "";

        String url = String.format(

                "http://maps.google.cn/maps/api/geocode/json?latlng=%s,%s&language=CN",

                latitude,longitude);

        URL myURL = null;

        URLConnection httpsConn = null;

        try {

            myURL = new URL(url);

        } catch (Exception e) {

            e.printStackTrace();

        }

        try {

            httpsConn = (URLConnection) myURL.openConnection();

            if (httpsConn != null) {

                InputStreamReader insr = new InputStreamReader(

                        httpsConn.getInputStream(), "UTF-8");

                BufferedReader br = new BufferedReader(insr);

                String data = null;

                while ((data = br.readLine()) != null) {

                    message = message+data;

                }

                insr.close();

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        return message;

    }
}
