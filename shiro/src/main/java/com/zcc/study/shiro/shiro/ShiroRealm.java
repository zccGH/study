package com.zcc.study.shiro.shiro;

import com.zcc.study.shiro.domain.Permission;
import com.zcc.study.shiro.domain.Role;
import com.zcc.study.shiro.domain.User;
import com.zcc.study.shiro.service.PermissionService;
import com.zcc.study.shiro.service.RoleService;
import com.zcc.study.shiro.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @ClassName ShiroRealm
 * @Description: 自定义real实现用户认证和授权
 * @Author chengcheng.zhao01
 * @Date 2020/8/20
 * @Version V1.0
 **/
@Component
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    PermissionService permissionService;

    /**
     * 实现用户授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String username =(String) principalCollection.getPrimaryPrincipal();
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        //根据用户名查询用户角色信息
        Set<Role> roles = roleService.listRoleByUsername(username);
        if (CollectionUtils.isNotEmpty(roles)) {
            for (Role role : roles) {
                simpleAuthorizationInfo.addRole(role.getRoleName());
                //根据角色id查询角色对应权限集合
                Set<Permission> permissions = permissionService.listPermissionByRoleId(role.getId());
                if (CollectionUtils.isNotEmpty(permissions)) {
                    for (Permission permission : permissions) {
                        simpleAuthorizationInfo.addRole(permission.getCode());
                    }
                }
            }
        }

        return simpleAuthorizationInfo;
    }

    /**
     * 实现用户认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的木器是在post请求的时候会先进行验证，然后再到请求、
        if(null==authenticationToken.getPrincipal()){
            return null;
        }
        //获取用户信息
        String username = authenticationToken.getPrincipal().toString();
        User user = userService.getUserByUserName(username);
        if (null==user) {
            //这里返回后会报对应的异常
            return null;
        }else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(username,user.getPassword(),getName());
            return simpleAuthenticationInfo;
        }
    }
}
