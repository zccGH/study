package com.zcc.study.shiro.exception;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.zcc.study.shiro.controller.BaseController;
import com.zcc.study.utils.config.HttpStatus;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

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
        Map<String,Object> map=new HashMap<>();
        if (e instanceof UnauthenticatedException) {
            new BaseController().getResponseData(HttpStatus.FORBIDDEN,"未认证，拒绝访问！");
        }else if(e instanceof UnauthorizedException){
            new BaseController().getResponseData(HttpStatus.UNAUTHORIZED,"授权，拒绝访问！");
        }else {
            new BaseController().getResponseData(HttpStatus.ERROR,e.getMessage());

        }
        fastJsonJsonView.setAttributesMap(map);
        modelAndView.setView(fastJsonJsonView);
        return modelAndView;
    }
}
