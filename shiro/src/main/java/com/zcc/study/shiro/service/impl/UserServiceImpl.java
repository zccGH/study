package com.zcc.study.shiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcc.study.shiro.constant.ShiroConstant;
import com.zcc.study.shiro.domain.User;
import com.zcc.study.shiro.mapper.UserMapper;
import com.zcc.study.shiro.service.UserService;
import com.zcc.study.shiro.util.MD5Util;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description: 用户业务实现类
 * @Author chengcheng.zhao01
 * @Date 2020/8/20
 * @Version V1.0
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    @Override
    public User getUserByUserName(String username) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        return this.baseMapper.selectOne(queryWrapper);
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @Override
    public boolean saveUser(User user) {
        //设置随机盐
        user.setSalt(RandomStringUtils.randomAlphanumeric(ShiroConstant.SALT_STR_LENGTH));
        //密码加密处理
        user.setPassword(MD5Util.encryption(user.getPassword(),user.getSalt()));
        return save(user);
    }
}
