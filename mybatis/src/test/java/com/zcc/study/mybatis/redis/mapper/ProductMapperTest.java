package com.zcc.study.mybatis.redis.mapper;

import com.zcc.study.mybatis.MybatisApplicationTests;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest extends MybatisApplicationTests {

    @Test
    void listProduct() {
        productMapper.selectProductList().forEach(System.out::println);
    }
}