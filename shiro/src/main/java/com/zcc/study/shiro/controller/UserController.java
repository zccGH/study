package com.zcc.study.shiro.controller;

import com.zcc.study.shiro.domain.User;
import com.zcc.study.shiro.service.UserService;
import com.zcc.study.utils.config.HttpStatus;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName UserController
 * @Description: 用户接口
 * @Author chengcheng.zhao01
 * @Date 2020/8/24
 * @Version V1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    /**
     * 添加用户
     * @return
     */
    @RequiresRoles(value = "超级管理员")
    @PostMapping
    public Map<String,Object> addUser(@RequestBody User user){
        boolean saveUser = userService.saveUser(user);
        if (saveUser) {
            return getResponseData(HttpStatus.SUCCESS,"添加成功");
        }else {
            return getResponseData(HttpStatus.SUCCESS,"添加失败");
        }
    }
}
