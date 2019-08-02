/*
package com.dousnl.aiways;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

public class Test {
    
    // ################################本互联互通的配置################################
    
    public static String LOCAL_OPERATORID = "hainantst";
    
    public static String LOCAL_OPERATOR_SECRET = "1234567890abcdef";
    
    public static String LOCAL_SIG_SECRET = "1234567890abcdef";
    
    public static String LOCAL_AES_SECRET = "1234567890abcdef";
    
    public static String LOCAL_AES_IV = "1234567890abcdef";
    
    // ################################本互联互通的配置################################
    
    // ################################星星充电互联互通配置################################
    
    public static String SERVER_OPERATOR_SECRET = "acb93539fc9bg78k";
    
    public static String SERVER_SIG_SECRET = "9af2e7b2d7562ad5";
    
    public static String SERVER_AES_SECRET = "a2164ada0026ccf7";
    
    public static String SERVER_AES_IV = "82c91325e74bef0f";
    
    public static String SERVER_OPERATORID = "313744932";
    
    // ################################星星充电用互联互通配置################################
    
    public static int SEQ = 1;
    
    public static String TEST_SERVER_URL = "http://dxp.test.ccchong.com:8081/evcs/20160701/";
    
    public static void main(String[] args) throws Exception {
        
        // 获得token
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("OperatorID", LOCAL_OPERATORID);
        params.put("OperatorSecret", SERVER_OPERATOR_SECRET);
        String token = getResultFromDxpApi(params, "query_token", null);
        System.out.println("token:" + token);
        
        // 通过token获得数据
        Map<String, Object> stationParams = new HashMap<String, Object>();
        stationParams.put("LastQueryTime", "2015-01-01 00:00:00");
        stationParams.put("PageNo", 1);
        stationParams.put("PageSize", 10);
        
        // 获取电站信息
        String stationInfo = getResultFromDxpApi(stationParams, "query_stations_info", token);
        System.out.println("stationInfo:" + stationInfo);
        
    }
    
    public static String getResultFromDxpApi(Map<String, Object> params, String apiName, String token) throws Exception {
        final String queryUrl = TEST_SERVER_URL + apiName;
        
        String responseBody = "";
        
        List<Header> headers = new ArrayList<>();
        try {
            headers.add(new BasicHeader("Content-Type", "application/json;charset=utf-8"));
            if (token != null) {
                headers.add(new BasicHeader("Authorization", "Bearer " + token));
            }
            
            responseBody = post(queryUrl, requestEncode(params), "utf-8", "utf-8", headers);
            
            Map<String, Object> resMap = responseDecode(responseBody);
            
            Integer failReason = (Integer)resMap.get("FailReason");
            
            if ("query_token".equals(apiName)) {
                if (failReason != null && failReason == 0) {
                    token = (String)resMap.get("AccessToken");
                } else {
                    token = "-1";
                }
                return token;
            } else {
                return JSON.toJSONString(resMap);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    // 获取Token数据请求加密
    public static String requestEncode(Map<String, Object> params) {
        
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        
        try {
            Map<String, Object> result = new HashMap<>();
            
            String seq = StringUtils.leftPad(String.valueOf(SEQ++), 4, '0');
            
            String aesData = AESUtils.Encrypt(JSON.toJSONString(params), SERVER_AES_SECRET, SERVER_AES_IV);
            
            String signData = HmacUtils.hmacMd5Hex(SERVER_SIG_SECRET, LOCAL_OPERATORID + aesData + timestamp + seq).toUpperCase();
            
            result.put("OperatorID", LOCAL_OPERATORID);
            result.put("TimeStamp", timestamp);
            result.put("Data", aesData);
            result.put("Sig", signData);
            result.put("Seq", seq);
            
            return JSON.toJSONString(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static String responseEncode(String operatorId, EvcsResponse response) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        
        if (response != null) {
            result.put("Ret", response.getRet());
            result.put("Msg", response.getMsg());
            
            // 如果返回结果正常
            if (response.getRet() == 0) {
                // 生成aesData
                result.put("Data", AESUtils.Encrypt(JSON.toJSONString(response.getData()), LOCAL_AES_SECRET, LOCAL_AES_IV));
                result.put("Sig",
                    HmacUtils.hmacMd5Hex(LOCAL_SIG_SECRET, response.getRet() + response.getMsg() + result.get("Data")).toUpperCase());
            }
        } else {
            result.put("Ret", 0);
        }
        
        return JSON.toJSONString(result);
    }
    
    // 获取Token数据返回解密
    public static Map<String, Object> responseDecode(String dataRet) throws Exception {
        try {
            Map<String, Object> requestParams = JSON.parseObject(dataRet, Map.class);
            
            if (requestParams == null) {
                throw new Exception("POST参数不合法,缺少必须的示例：OperatorID,sig,TimeStamp,Seq,Data五个参数");
            }
            
            if (requestParams.get("Data") == null) {
                throw new Exception((String)requestParams.get("Msg"));
            }
            
            String aesData = (String)requestParams.get("Data");
            
            // data反向aes解密后json反序列化
            String dataStr = AESUtils.Decrypt(aesData, SERVER_AES_SECRET, SERVER_AES_IV);
            
            Map<String, Object> decodeParamMap = JSON.parseObject(dataStr, Map.class);
            
            return decodeParamMap;
        } catch (Exception e) {
            throw e;
        }
    }
    
    */
/**
     * 
     * <一句话功能简述>
     * 
     * @param url
     * @param body
     * @param requestCharset
     * @param responseCharset
     * @param headers
     * @return
     *
     *//*

    public static String post(String url, String body, String requestCharset, String responseCharset, List<Header> headers) {
        
        if ((url == null) || (StringUtils.isEmpty(url))) {
            return null;
        }
        
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        
        StringEntity entity = new StringEntity(body, requestCharset);
        
        HttpPost hp = new HttpPost(url);
        hp.setEntity(entity);
        if (CollectionUtils.isNotEmpty(headers)) {
            for (Header header : headers) {
                if (hp.getFirstHeader(header.getName()) != null)
                    hp.setHeader(header);
                else {
                    hp.addHeader(header);
                }
            }
            
        }
        
        String responseStr = null;
        try {
            byte[] responseByte = (byte[])httpclient.execute(hp, new ResponseHandler() {
                public byte[] handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
                    HttpEntity entity = response.getEntity();
                    if (entity != null) {
                        String charset = (EntityUtils.getContentCharSet(entity) == null) ? "GBK" : EntityUtils.getContentCharSet(entity);
                        if (String.valueOf(response.getFirstHeader("Content-Encoding")).toLowerCase().indexOf("gzip") > -1) {
                            entity = new GzipDecompressingEntity(entity);
                        }
                        
                        return EntityUtils.toByteArray(entity);
                    }
                    return null;
                }
            });
            responseStr = new String(responseByte, responseCharset);
        } catch (ClientProtocolException e) {
            throw new RuntimeException("客户端连接协议错误", e);
        } catch (IOException e) {
            throw new RuntimeException("IO操作异常", e);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseStr;
    }
    
    private static List<NameValuePair> getParamsList(Map<String, String> paramsMap) {
        List params = new ArrayList();
        
        if ((paramsMap != null) && (paramsMap.size() > 0)) {
            for (Map.Entry map : paramsMap.entrySet()) {
                params.add(new BasicNameValuePair((String)map.getKey(), (String)map.getValue()));
            }
        }
        
        return params;
    }
}
*/
