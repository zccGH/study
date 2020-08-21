package com.zcc.study.shiro.shiro;

import com.zcc.study.shiro.constant.ShiroConstant;
import com.zcc.study.shiro.exception.ShiroExceptionHandler;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName ShiroConfig
 * @Description: shiro权限框架配置类
 * @Author chengcheng.zhao01
 * @Date 2020/8/20
 * @Version V1.0
 **/
@Configuration
public class ShiroConfig {

    //凭证匹配器，自定义密码加密方式
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher=new HashedCredentialsMatcher();
        //三列算法，使用MD5算法
        hashedCredentialsMatcher.setHashAlgorithmName(ShiroConstant.HASH_ALGORITHM_NAME);
        //三列次数
        hashedCredentialsMatcher.setHashIterations(ShiroConstant.HASH_ITERATIONS);
        return hashedCredentialsMatcher;
    }

    //创建自定义realm，注入凭证匹配器
    @Bean
    public MyShiroRealm shiroRealm(){
        MyShiroRealm myShiroRealm =new MyShiroRealm();
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShiroRealm;
    }

    /**
     * 注册自定义sessionManager
     * @return
     */
    @Bean
    public SessionManager sessionManager(){
        MySessionManager mySessionManager=new MySessionManager();
        return mySessionManager;
    }

    //创建权限管理器，注入自定义验证方式
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager =new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(shiroRealm());
        defaultWebSecurityManager.setSessionManager(sessionManager());
        return defaultWebSecurityManager;
    }

    /**
     * 创建过滤器
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> map=new LinkedHashMap<>();
        //注意过滤器配置顺序，不能颠倒
        //配置 退出过滤器，其中的具体的代码Shiro已经实现，登出后跳转配置的loginUrl
        map.put("/logout","logout");
        //配置 放行的资源路径 顺序判断
        //系统静态资源放行
        map.put("/static/**","anon");
        map.put("/ajaxLogin","anon");
        map.put("/login","anon");
        //配置其它资源路径需要认证
        map.put("/**","authc");
        //配置shiro默认登录界面地址，前后端分离中登录界面跳转应有前端南路由控制，后台仅返回json数据
        shiroFilterFactoryBean.setLoginUrl("/shiro/ajaxLogin");
        //登录成功后要跳转的地址，在前后端分离项目中，不需配置
        //shiroFilterFactoryBean.setSuccessUrl("/index");
        //未授权页面,前后端分离项目中由前端配置，后端返回响应的状态码即可；
        //shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    /**
     * 开启shiro aop注解支持
     * 使用代理方式；所以需要开启代码支持
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor=new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * 注册全局异常处理
     * @return
     */
    @Bean(name = "exceptionHandler")
    public HandlerExceptionResolver handlerExceptionResolver(){
        return new ShiroExceptionHandler();
    }

}
