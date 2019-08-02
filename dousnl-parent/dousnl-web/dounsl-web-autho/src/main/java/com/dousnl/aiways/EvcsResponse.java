package com.dousnl.aiways;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class EvcsResponse {
    
    private int ret = 0;
    
    private String msg = StringUtils.EMPTY;
    
    private Map<String, Object> data = new HashMap<String, Object>();
    
    private String sig;
    
    public EvcsResponse() {
    }
    
    public void setRet(int ret) {
        this.ret = ret;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public void setData(Map<String, Object> data) {
        this.data = data;
    }
    
    public void setSig(String sig) {
        this.sig = sig;
    }
    
    public String getSig() {
        return sig;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public int getRet() {
        return ret;
    }
    
    public Map<String, Object> getData() {
        return data;
    }
    
}
