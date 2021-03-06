package com.zcc.study.mybatis.redis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcc.study.mybatis.redis.domain.Product;
import com.zcc.study.mybatis.redis.mapper.ProductMapper;
import com.zcc.study.mybatis.redis.service.ProductService;
import com.zcc.study.mybatis.redis.utils.RedisUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
public class ProductServiceImpl extends ServiceImpl<ProductMapper,Product> implements ProductService {

    Logger logger= LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

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
            logger.info("缓存中存在值，从缓存中拿数据");
            list= (List<Product>) redisList.get("productList", 0L, -1L);
        }else {
            logger.info("缓存中没有数据，从数据库拿数据");
            list=productMapper.selectProductList();
            logger.info("将数据重新放入缓存");
            redisList.set("productList", list);
        }
        return list;
    }

}
