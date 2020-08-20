package com.zcc.study.shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcc.study.shiro.domain.Permission;

import java.util.Set;

/**
 * @ClassName PermissionService
 * @Description: 系统用户权限业务接口类
 * @Author chengcheng.zhao01
 * @Date 2020/8/20
 * @Version V1.0
 **/
public interface PermissionService extends IService<Permission> {


    /**
     * 根据角色id查询该角色拥有的权限信息
     * @param roleId
     * @return
     */
    Set<Permission> listPermissionByRoleId(Long roleId);
}
