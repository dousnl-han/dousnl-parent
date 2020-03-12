package com.dousnl.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author hanliang
 * @version 1.0
 * @date 2019/8/2 14:33
 */
@Data
//@Document(indexName = "testgoods",type = "goods")
@AllArgsConstructor
@NoArgsConstructor
public class GoodsInfo {
    private Long id;
    private String name;
    private String desc;
}
