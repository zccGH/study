package com.zcc.study.shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcc.study.shiro.domain.User;

/**
 * @ClassName UserService
 * @Description: 系统用户业务接口类
 * @Author chengcheng.zhao01
 * @Date 2020/8/20
 * @Version V1.0
 **/
public interface UserService extends IService<User> {

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    User getUserByUserName(String username);

    /**
     * 保存用户
     * @param user
     * @return
     */
    boolean saveUser(User user);

}
