package com.zcc.study.shiro.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        return null;
    }
}
