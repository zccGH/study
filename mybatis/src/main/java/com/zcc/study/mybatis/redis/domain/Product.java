package com.zcc.study.mybatis.redis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Product
 * @Description: 实体隐射类
 * @Author chengcheng.zhao01
 * @Date 2020/11/23
 * @Version V1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    private Integer productId;
    private String productCategories;

}
