package com.zcc.study.utils.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcc.study.utils.domain.OrganizationDo;

import java.util.List;
import java.util.Set;

/**
 * @ClassName OrganizationService
 * @Description: 组织结构业务接口
 * @Author chengcheng.zhao01
 * @Date 2020/8/17
 * @Version V1.0
 **/
public interface OrganizationService extends IService<OrganizationDo> {

    /**
     * id可以为父级Id或者此条记录的id，如果id为空，则默认查询所有
     * @param id
     * @return
     */
    List<OrganizationDo> findTree(String id);

    /**
     * 根据id批量删除
     * @param organizationDoSet
     * @return
     */
    int modifyOrganizationByIds(Set<OrganizationDo> organizationDoSet);
}
