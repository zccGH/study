package com.zcc.study.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcc.study.shiro.domain.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * @ClassName RoleMapper
 * @Description: 系统用户角色持久层接口
 * @Author chengcheng.zhao01
 * @Date 2020/8/20
 * @Version V1.0
 **/
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户名查询该用户所有的角色信息
     * @param username
     * @return
     */
    Set<Role> selectRolesByUserName(String username);
}
