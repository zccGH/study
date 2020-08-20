package com.zcc.study.utils.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BaseController
 * @Description: 接口基类
 * @Author chengcheng.zhao01
 * @Date 2020/8/17
 * @Version V1.0
 **/
@RestController
public class BaseController {

    /**
     * 访问成功返回结果封装
     * @param code 响应状态码
     * @param message 响应消息
     * @return
     */
    public Map<String,Object> resultData(Integer code, String message, List<?> dataList){
        Map<String,Object> map=new HashMap<>();
        map.put("code",code);
        map.put("message",message);
        map.put("data",dataList);
        return map;
    }
}
