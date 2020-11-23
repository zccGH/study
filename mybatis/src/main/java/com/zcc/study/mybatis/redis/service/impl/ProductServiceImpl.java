package com.zcc.study.mybatis.redis.service.impl;

import com.alibaba.druid.support.logging.Log;
import com.zcc.study.mybatis.redis.domain.Product;
import com.zcc.study.mybatis.redis.mapper.ProductMapper;
import com.zcc.study.mybatis.redis.service.ProductService;
import com.zcc.study.mybatis.redis.utils.RedisUtil;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ProductServiceImpl
 * @Description: TODO
 * @Author chengcheng.zhao01
 * @Date 2020/11/23
 * @Version V1.0
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private RedisUtil.RedisList redisList;
    @Override
    public List<Product> listProduct() {
        List<Product> list=new ArrayList<>();
        //判断缓存中是否有这个list
        if (redisUtil.haskey("productList")){
            list=redisList.get("productList", 0L, -1L);
        }else {
            list=productMapper.selectProductList();
            redisList.set("productList", list);
        }
        return list;
    }
}
