package com.zcc.study.shiro.mapper;

import com.zcc.study.shiro.ShiroApplicationTests;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleMapperTest extends ShiroApplicationTests {

    @Test
    void selectRolesByUserName() {
        roleMapper.selectRolesByUserName("赵成成").forEach(System.out::println);
    }
}