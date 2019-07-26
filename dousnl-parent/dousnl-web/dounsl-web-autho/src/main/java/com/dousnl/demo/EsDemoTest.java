package com.dousnl.demo;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class EsDemoTest {

    public static void main(String[] args) {
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder=QueryBuilders.boolQuery();
        TermQueryBuilder termQuery = QueryBuilders.termQuery("key.keyword", "1");
        boolQueryBuilder.must(termQuery);
        WildcardQueryBuilder aCase = QueryBuilders.wildcardQuery("case.keyword", "*jack*");
        WildcardQueryBuilder house = QueryBuilders.wildcardQuery("house.keyword", "*jack*");
        QueryBuilders.wildcardQuery("app","wechat");
        boolQueryBuilder.should(aCase);
        boolQueryBuilder.should(house);
        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery("dousnl.keyword", "name", "address");
        boolQueryBuilder.must(multiMatchQueryBuilder);
        SearchSourceBuilder query = ssb.query(boolQueryBuilder).from(20).size(10);
        System.out.println(ssb.toString());
        List<User> list= Lists.newArrayList();
        Map<String,User> map= Maps.newHashMap();
        map.put("key1",new User("key1",18));
        map.put("key2",new User("key2",19));
        list.addAll(map.values());
        ArrayList<User> users = new ArrayList<>(map.values());
        log.info(JSON.toJSONString(list));
    }
}
