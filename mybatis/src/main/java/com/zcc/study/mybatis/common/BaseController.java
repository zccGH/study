package com.zcc.study.mybatis.common;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName BaseController
 * @Description: 接口基类
 * @Author chengcheng.zhao01
 * @Date 2020/11/24
 * @Version V1.0
 **/
public class BaseController {

    /**
     * 统一封装返回结果
     * @param list  数据结果集
     * @param message  状态信息
     * @return
     */
    public ResponseResult ok(List<?> list,String message){
        ResponseResult responseResult=new ResponseResult();
        responseResult.setCode(HttpStatus.SUCCESS);
        responseResult.setMessage(message);
        responseResult.setRows(list);
        responseResult.setTotal((long) list.size());
        return responseResult;
    }
}
