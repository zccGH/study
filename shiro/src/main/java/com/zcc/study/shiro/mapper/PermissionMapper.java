package com.zcc.study.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcc.study.shiro.domain.Permission;

import java.util.Set;

/**
 * @ClassName PermissionMapper
 * @Description: 系统用户权限持久层接口类
 * @Author chengcheng.zhao01
 * @Date 2020/8/20
 * @Version V1.0
 **/
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 根据角色id查询该角色对应的权限集合
     * @param roleId
     * @return
     */
    Set<Permission> listPermissionsByRoleId(Long roleId);
}
