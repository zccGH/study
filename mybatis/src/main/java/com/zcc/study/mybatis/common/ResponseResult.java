package com.zcc.study.mybatis.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ResponseResult
 * @Description: 返回前端结果分装类
 * @Author chengcheng.zhao01
 * @Date 2020/11/24
 * @Version V1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult implements Serializable {

    private static final long serialVersionUID = -8335899820376069193L;
    /**
     * 数据结果集
     */
    private List<?> rows;
    /**
     * 总记录数
     */
    private Long total;
    /**
     * 状态信息
     */
    private String message;
    /**
     * 消息状态码
     */
    private int code;

    public ResponseResult(List<?> list,Long total){
        this.rows=list;
        this.total=total;
    }

}
