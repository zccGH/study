package com.zcc.study.shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcc.study.shiro.domain.Role;

import java.util.Set;

/**
 * @ClassName RoleService
 * @Description: 系统用户角色业务接口类
 * @Author chengcheng.zhao01
 * @Date 2020/8/20
 * @Version V1.0
 **/
public interface RoleService extends IService<Role> {

    /**
     * 根据用户名查询用户角色集合
     * @param username
     * @return
     */
    Set<Role> listRoleByUsername(String username);
}
