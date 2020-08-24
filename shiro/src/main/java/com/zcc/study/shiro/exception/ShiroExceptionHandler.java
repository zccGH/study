package com.zcc.study.shiro.exception;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.zcc.study.shiro.controller.BaseController;
import com.zcc.study.utils.config.HttpStatus;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ShiroExceptionHandler
 * @Description: shiro全局异常处理类
 * @Author chengcheng.zhao01
 * @Date 2020/8/20
 * @Version V1.0
 **/
public class ShiroExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView=new ModelAndView();
        FastJsonJsonView fastJsonJsonView=new FastJsonJsonView();
        if (e instanceof AuthenticationException) {
            fastJsonJsonView.setAttributesMap(new BaseController().getResponseData(HttpStatus.FORBIDDEN,"未认证，拒绝访问！"));
        }else if(e instanceof AuthorizationException){
            fastJsonJsonView.setAttributesMap(new BaseController().getResponseData(HttpStatus.UNAUTHORIZED,"未授权，拒绝访问！"));
        }else {
            fastJsonJsonView.setAttributesMap(new BaseController().getResponseData(HttpStatus.ERROR,e.getMessage()));
        }
        modelAndView.setView(fastJsonJsonView);
        return modelAndView;
    }
}
