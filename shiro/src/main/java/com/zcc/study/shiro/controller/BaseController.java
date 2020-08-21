package com.zcc.study.shiro.controller;

import com.zcc.study.shiro.config.ResponseData;
import com.zcc.study.utils.config.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BaseMapper
 * @Description: 系统接口基类
 * @Author chengcheng.zhao01
 * @Date 2020/8/21
 * @Version V1.0
 **/
@RestController
public class BaseController {

    /**
     * 不需要返回数据的情况下，只返回响应结果
     * @param code
     * @param message
     * @return
     */
    public Map<String,Object> getResponseData(Integer code, String message){
        Map<String,Object> responseMap=new HashMap<>();
        responseMap.put("code",code);
        responseMap.put("message",message);
        return responseMap;
    }

    /**
     * 不需要返回数据的情况下，只返回响应结果
     * @param code
     * @param message
     * @return
     */
    public Map<String,Object> getResponseData(Integer code, String message, String token){
        Map<String,Object> responseMap=new HashMap<>();
        responseMap.put("code",code);
        responseMap.put("message",message);
        responseMap.put("token",token);
        return responseMap;
    }

    /**
     * 返回数据和响应结果
     * @param dataList
     * @return
     */
    public Map<String,Object> getResponseData(List<?> dataList){
        Map<String,Object> responseMap=new HashMap<>();
        responseMap.put("code",HttpStatus.SUCCESS);
        responseMap.put("message","获取数据成功");
        responseMap.put("rowData",dataList);
        return responseMap;
    }

}
