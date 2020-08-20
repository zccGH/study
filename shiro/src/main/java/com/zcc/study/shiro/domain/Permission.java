package com.zcc.study.shiro.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Permission
 * @Description: 系统资源实体类
 * @Author chengcheng.zhao01
 * @Date 2020/8/20
 * @Version V1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission implements Serializable {

    private static final long serialVersionUID = 7591796795298583648L;
    private Long id;
    /**
     * 操作代码
     */
    private String code;
    /**
     * 资源名称
     */
    private String permissionName;
}
