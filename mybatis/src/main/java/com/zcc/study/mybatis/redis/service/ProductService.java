package com.zcc.study.mybatis.redis.service;

import com.zcc.study.mybatis.redis.domain.Product;

import java.util.List;

/**
 * @ClassName ProductService
 * @Description: TODO
 * @Author chengcheng.zhao01
 * @Date 2020/11/23
 * @Version V1.0
 **/
public interface ProductService {

    List<Product> listProduct();
}
