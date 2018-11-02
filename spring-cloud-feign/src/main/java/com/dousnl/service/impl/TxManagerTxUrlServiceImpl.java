package com.dousnl.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.codingapi.tx.config.service.TxManagerTxUrlService;

/**
 * create by lorne on 2017/11/18
 */
@Component
public class TxManagerTxUrlServiceImpl implements TxManagerTxUrlService{


    @Value("${tx.manager.url}")
    private String url;

    @Override
    public String getTxUrl() {
        System.out.println("load tm.manager.url ");
        return url;
    }
}
