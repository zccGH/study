package com.zcc.study.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcc.study.shiro.domain.Permission;
import com.zcc.study.shiro.mapper.PermissionMapper;
import com.zcc.study.shiro.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @ClassName PermissionServiceImpl
 * @Description: 系统用户权限业务实现类
 * @Author chengcheng.zhao01
 * @Date 2020/8/20
 * @Version V1.0
 **/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    @Override
    public Set<Permission> listPermissionByRoleId(Long roleId) {
        return this.baseMapper.listPermissionsByRoleId(roleId);
    }
}
