package com.zcc.study.shiro.service;

import com.zcc.study.shiro.ShiroApplicationTests;
import com.zcc.study.shiro.domain.Role;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RoleServiceTest extends ShiroApplicationTests {

    @Test
    void listRoleByUsername() {
        Set<Role> roles = roleService.listRoleByUsername("赵成成");
        System.out.println(roles);
    }
}