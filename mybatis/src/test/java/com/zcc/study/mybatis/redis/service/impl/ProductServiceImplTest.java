package com.zcc.study.mybatis.redis.service.impl;

import com.zcc.study.mybatis.MybatisApplicationTests;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest extends MybatisApplicationTests {

    @Test
    void listProduct() {
        productServiceImpl.listProduct();
    }
}