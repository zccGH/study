package com.zcc.study.shiro.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

/**
 * @ClassName Role
 * @Description: 系统角色实体类
 * @Author chengcheng.zhao01
 * @Date 2020/8/20
 * @Version V1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    private static final long serialVersionUID = -7072495320617380029L;
    private Long id;
    private String roleName;
    /**
     * 角色对应的权限集合
     */
    @TableField(exist = false)
    private Set<Permission> permissions;
}
