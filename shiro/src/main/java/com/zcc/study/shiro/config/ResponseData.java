package com.zcc.study.shiro.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName ResponseData
 * @Description: 返回前端结果数据封装类
 * @Author chengcheng.zhao01
 * @Date 2020/8/21
 * @Version V1.0
 **/
@Data
@NoArgsConstructor
public class ResponseData implements Serializable {
    private static final long serialVersionUID = -1308168341076146019L;
    /**
     * 总记录数
     */
    private long total;
    /**
     * 列表数据
     */
    private List<?> rowsData;
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 状态消息
     */
    private String message;
    /**
     * 返回前端token
     */
    private String token;

    /**
     * 无列表数据时返回请求状态消息
     * @param code
     * @param message
     */
    public ResponseData(Integer code,String message){
        this.code=code;
        this.message=message;
    }

    /**
     * 登录成功消息封装
     * @param code
     * @param message
     */
    public ResponseData(Integer code,String message,String token){
        this.code=code;
        this.message=message;
        this.token=token;
    }
}
