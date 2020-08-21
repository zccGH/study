package com.zcc.study.shiro.constant;

/**
 * @ClassName ShiroConstant
 * @Description: shiro权限框架常量配置类
 * @Author chengcheng.zhao01
 * @Date 2020/8/20
 * @Version V1.0
 **/
public class ShiroConstant {
    //密码加密算法
    public static final String HASH_ALGORITHM_NAME="md5";
    //散列次数
    public static final Integer HASH_ITERATIONS=2;
    //用户状态-正常
    public static final Integer USER_STATE_NORMAL=0;
    //用户状态-锁定
    public static final Integer USER_STATE_LOCKED=1;


}
