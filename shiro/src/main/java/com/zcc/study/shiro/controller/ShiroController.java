package com.zcc.study.shiro.controller;

import com.alibaba.fastjson.JSONObject;
import com.zcc.study.shiro.config.ResponseData;
import com.zcc.study.shiro.domain.User;
import com.zcc.study.utils.config.HttpStatus;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName ShiroController
 * @Description: 用户认知接口类
 * @Author chengcheng.zhao01
 * @Date 2020/8/21
 * @Version V1.0
 **/
@RestController
public class ShiroController extends BaseController {

    /**
     * 用户登录
     * @param user
     * @return
     */
    @PostMapping("/ajaxLogin")
    public Map<String,Object> ajaxLogin(@RequestBody User user){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {
            subject.login(usernamePasswordToken);
            return getResponseData(HttpStatus.SUCCESS,"登录成功",String.valueOf(subject.getSession().getId()));
        } catch (IncorrectCredentialsException e) {
            return getResponseData(HttpStatus.UNAUTHORIZED,"密码错误");
        }catch (LockedAccountException e){
            return  getResponseData(HttpStatus.UNAUTHORIZED,"账户锁定");
        }catch (UnknownAccountException e){
            return getResponseData(HttpStatus.UNAUTHORIZED,"账号不存在");
        }catch (Exception e){
            e.printStackTrace();
            return getResponseData(HttpStatus.ERROR,"系统错误");
        }
    }

    /**
     * 退出登录
     */
    @PostMapping("/logout")
    public void logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
}
