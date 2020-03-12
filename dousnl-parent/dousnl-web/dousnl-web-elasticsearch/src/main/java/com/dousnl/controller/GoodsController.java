package com.dousnl.controller;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author hanliang
 * @version 1.0
 * @date 2019/8/2 14:39
 */
@RestController
public class GoodsController {

    //@Autowired
    //private GoodsRepository goodsRepository;
    @Autowired
    private RestHighLevelClient client;

    //http://localhost:8888/save
//    @GetMapping("save")
//    public String save(){
//        GoodsInfo goodsInfo = new GoodsInfo(System.currentTimeMillis(),
//                "商品"+System.currentTimeMillis(),"这是一个测试商品");
//        goodsRepository.save(goodsInfo);
//        return "success";
//    }
//
//    //http://localhost:8888/delete?id=1525415333329
//    @GetMapping("delete")
//    public String delete(long id){
//        goodsRepository.delete(new GoodsInfo(id,null,null));
//        return "success";
//    }
//
//    //http://localhost:8888/update?id=1525417362754&name=修改&description=修改
//    @GetMapping("update")
//    public String update(long id,String name,String description){
//        GoodsInfo goodsInfo = new GoodsInfo(id,
//                name,description);
//        goodsRepository.save(goodsInfo);
//        return "success";
//    }
//
//    //http://localhost:8888/getOne?id=1525417362754
//    @GetMapping("getOne")
//    public GoodsInfo getOne(long id){
//        GoodsInfo goodsInfo = goodsRepository.findOne(id);
//        return goodsInfo;
//    }
//
//    @GetMapping("getOneLike/{name}")
//    public List<GoodsInfo> getOneLike(@PathVariable("name") String name){
//        QueryStringQueryBuilder builder=new QueryStringQueryBuilder(name);
//        Iterable<GoodsInfo> infos = goodsRepository.search(builder);
//        Iterator<GoodsInfo> iterator = infos.iterator();
//        List<GoodsInfo> list= new ArrayList<>();
//        while (iterator.hasNext()){
//            GoodsInfo next = iterator.next();
//            list.add(next);
//        }
//        System.out.println("list:"+ JSON.toJSONString(list));
//        return list;
//    }

    @GetMapping("/order/getById/{id}")
    public Map<String,Object> getOrder(@PathVariable("id")String id){
        GetRequest getRequest=new GetRequest("first_index","user",id);
        Map map=new HashMap();
        GetResponse response=null;
        try{
            response= client.get(getRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(response.isExists()){
            map.put("success",true);
            map.put("data",response.getSource());
        }else{
            map.put("success",false);
        }
        return map;
    }

    @GetMapping("/order/getById1/{id}")
    public String getOrderNew(@PathVariable("id")String id){
        SearchSourceBuilder sourceBuilder=new SearchSourceBuilder();
        SearchRequest request=new SearchRequest();
        request.indices("first_index");
        request.source(sourceBuilder);
        //请求
        System.out.println(request.source().toString());
        SearchResponse rp=null;
        try {
            rp = client.search(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(rp));
        SearchHits hits = rp.getHits();
        SearchHit[] hits1 = hits.getHits();
        final SearchHit documentFields = hits1[0];
        String sourceAsString = documentFields.getSourceAsString();
        System.out.println("sourceAsString:"+sourceAsString);
        return JSON.toJSONString(rp);
    }


}
