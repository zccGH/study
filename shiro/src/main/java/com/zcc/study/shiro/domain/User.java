package com.zcc.study.shiro.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

/**
 * @ClassName User
 * @Description: 系统用户实体类
 * @Author chengcheng.zhao01
 * @Date 2020/8/20
 * @Version V1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 6778400372965062414L;
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户对应的角色集合
     */
    @TableField(exist = false)
    private Set<Role> roles;
}
