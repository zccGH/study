package com.zcc.study.mybatis.redis.controller;

import com.zcc.study.mybatis.common.BaseController;
import com.zcc.study.mybatis.common.ResponseResult;
import com.zcc.study.mybatis.redis.domain.Product;
import com.zcc.study.mybatis.redis.mapper.ProductMapper;
import com.zcc.study.mybatis.redis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ProductController
 * @Description: redis测试接口
 * @Author chengcheng.zhao01
 * @Date 2020/11/24
 * @Version V1.0
 **/
@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResponseResult listProduct(){
        List<Product> list = productService.listProduct();
        return ok(list, "查询成功");
    }
}
