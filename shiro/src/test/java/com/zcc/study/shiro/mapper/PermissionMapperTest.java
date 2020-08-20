package com.zcc.study.shiro.mapper;

import com.zcc.study.shiro.ShiroApplicationTests;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermissionMapperTest extends ShiroApplicationTests {

    @Test
    void listPermissionsByRoleId() {
        permissionMapper.listPermissionsByRoleId(1L).forEach(System.out::println);
    }
}