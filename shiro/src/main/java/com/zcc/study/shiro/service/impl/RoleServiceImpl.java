package com.zcc.study.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcc.study.shiro.domain.Role;
import com.zcc.study.shiro.mapper.RoleMapper;
import com.zcc.study.shiro.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @ClassName RoleServiceImpl
 * @Description: 系统用户角色业务实现类
 * @Author chengcheng.zhao01
 * @Date 2020/8/20
 * @Version V1.0
 **/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Override
    public Set<Role> listRoleByUsername(String username) {
        return this.baseMapper.selectRolesByUserName(username);
    }
}
