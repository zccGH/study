package com.zcc.study.mybatis.redis.service;

import com.zcc.study.mybatis.MybatisApplicationTests;
import com.zcc.study.mybatis.redis.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;


class ProductServiceTest extends MybatisApplicationTests {

    @Test
    void listProduct() {
        productService.listProduct().forEach(System.out::println);
    }
}