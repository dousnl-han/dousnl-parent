package com.dousnl.controller;

import com.dousnl.domain.GoodsInfo;
import com.dousnl.mapper.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author hanliang
 * @version 1.0
 * @date 2019/8/2 14:39
 */
@RestController
public class GoodsController {

    @Autowired
    private GoodsRepository goodsRepository;

    //http://localhost:8888/save
    @GetMapping("save")
    public String save(){
        GoodsInfo goodsInfo = new GoodsInfo(System.currentTimeMillis(),
                "商品"+System.currentTimeMillis(),"这是一个测试商品");
        goodsRepository.save(goodsInfo);
        return "success";
    }

    //http://localhost:8888/delete?id=1525415333329
    @GetMapping("delete")
    public String delete(long id){
        goodsRepository.delete(new GoodsInfo(id,null,null));
        return "success";
    }

    //http://localhost:8888/update?id=1525417362754&name=修改&description=修改
    @GetMapping("update")
    public String update(long id,String name,String description){
        GoodsInfo goodsInfo = new GoodsInfo(id,
                name,description);
        goodsRepository.save(goodsInfo);
        return "success";
    }

    //http://localhost:8888/getOne?id=1525417362754
    @GetMapping("getOne")
    public GoodsInfo getOne(long id){
        GoodsInfo goodsInfo = goodsRepository.findOne(id);
        return goodsInfo;
    }
}
