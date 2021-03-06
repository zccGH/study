package com.zcc.study.shiro.mapper;

import com.zcc.study.shiro.ShiroApplicationTests;
import com.zcc.study.shiro.domain.Role;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RoleMapperTest extends ShiroApplicationTests {

    @Test
    void selectRolesByUserName() {
        Set<Role> roles = roleMapper.selectRolesByUserName("赵成成");
        System.out.println(roles);
    }
}