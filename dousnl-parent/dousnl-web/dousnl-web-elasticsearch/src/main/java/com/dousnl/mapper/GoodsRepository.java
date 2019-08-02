package com.dousnl.mapper;

import com.dousnl.domain.GoodsInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author hanliang
 * @version 1.0
 * @date 2019/8/2 14:35
 */
@Component
public interface GoodsRepository extends ElasticsearchRepository<GoodsInfo,Long> {

}
