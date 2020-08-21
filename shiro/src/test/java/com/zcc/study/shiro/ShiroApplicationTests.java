package com.zcc.study.shiro;

import com.zcc.study.shiro.domain.Permission;
import com.zcc.study.shiro.mapper.PermissionMapper;
import com.zcc.study.shiro.mapper.RoleMapper;
import com.zcc.study.shiro.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShiroApplicationTests {

    @Autowired
    protected RoleMapper roleMapper;
    @Autowired
    protected PermissionMapper permissionMapper;
    @Autowired
    protected UserService userService;

}
