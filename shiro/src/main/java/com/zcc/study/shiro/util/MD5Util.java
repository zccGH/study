package com.zcc.study.shiro.util;

import com.zcc.study.shiro.constant.ShiroConstant;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MD5Util
 * @Description: MD5加密算法工具类
 * @Author chengcheng.zhao01
 * @Date 2020/8/21
 * @Version V1.0
 **/
public class MD5Util {


    public static void main(String[] args) {

        List<String> list=new ArrayList<>();
        list.add(null);
        System.out.println(CollectionUtils.isNotEmpty(list));
    }
    /**
     * md5密码加密
     * @param password
     * @param salt
     * @return
     */
    public static String encryption(String password,String salt){
        Md5Hash md5Hash=new Md5Hash(password,ByteSource.Util.bytes(salt),ShiroConstant.HASH_ITERATIONS);
        return md5Hash.toString();
    }
}
