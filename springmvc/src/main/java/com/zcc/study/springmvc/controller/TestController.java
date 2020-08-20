package com.zcc.study.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 赵成成
 * @version 1.0
 * @Description 测试接口
 * @date
 */
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("test")
    public String test(){
        return null;
    }
}
