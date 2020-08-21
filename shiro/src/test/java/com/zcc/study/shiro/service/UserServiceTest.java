package com.zcc.study.shiro.service;

import com.zcc.study.shiro.ShiroApplicationTests;
import com.zcc.study.shiro.domain.User;
import com.zcc.study.shiro.util.MD5Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest extends ShiroApplicationTests {

    @Test
    void getUserByUserName() {

    }

    @Test
    void saveUser() {
        User user=new User();
        user.setUsername("赵成成");
        user.setSalt("zcc123");
        user.setPassword("123456");
        user.setUserState(0);
        userService.saveUser(user);
    }
}