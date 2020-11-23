package com.zcc.study.mybatis.redis.mapper;

import com.zcc.study.mybatis.redis.domain.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName ProductDao
 * @Description: TODO
 * @Author chengcheng.zhao01
 * @Date 2020/11/23
 * @Version V1.0
 **/
@Mapper
public interface ProductMapper {

    /**
     * 查询图书列表
     * @return
     */
    List<Product> selectProductList();
}
