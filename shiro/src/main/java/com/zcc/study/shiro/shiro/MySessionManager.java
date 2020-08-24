package com.zcc.study.shiro.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * @ClassName MySessionManager
 * @Description: 自定义sessionId获取
 * @Author chengcheng.zhao01
 * @Date 2020/8/21
 * @Version V1.0
 * 传统结构项目中，shiro从cookie中读取sessionId以此来维持会话，在前后端分离的项目中（也可在移动APP项目使用），
 * 我们选择在ajax的请求头中传递sessionId，因此需要重写shiro获取sessionId的方式。
 * 自定义MySessionManager类继承DefaultWebSessionManager类，重写getSessionId方法
 **/
public class MySessionManager extends DefaultWebSessionManager {
    private static final String AUTHORIZATION="Authorization";
    private static final String REFERENCED_SESSION_ID_SOURCE="Stateless request";

    public MySessionManager(){
        super();
        /**
         * shiro session默认失效时间是30min,可以自定义session失效时间
         * 一下表示设置session过期时间为24小时
         */
        setGlobalSessionTimeout(DEFAULT_GLOBAL_SESSION_TIMEOUT*2);
    }

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response){
        String id = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
        //如果请求头中有Authorization,则其值为sessionId
        if (StringUtils.isNotEmpty(id)) {
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,REFERENCED_SESSION_ID_SOURCE);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID,id);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID,Boolean.TRUE);
            return id;
        }else {
            //否则按默认规则从cookie取sessionId
            return super.getSessionId(request,response);
        }
    }
}
