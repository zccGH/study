package com.zcc.study.mybatis;

import com.zcc.study.mybatis.redis.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisApplicationTests {

  @Autowired
  protected ProductMapper productMapper;

}
