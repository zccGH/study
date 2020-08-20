package com.zcc.study.utils.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcc.study.utils.constant.AttributeStatusConstant;
import com.zcc.study.utils.domain.OrganizationDo;
import com.zcc.study.utils.mapper.OrganizationMapper;
import com.zcc.study.utils.service.OrganizationService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName OrganizationServiceImpl
 * @Description: 组织结构业务实现类
 * @Author chengcheng.zhao01
 * @Date 2020/8/17
 * @Version V1.0
 **/
@Service
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, OrganizationDo> implements OrganizationService {

    /**
     * id可以为父级Id或者此条记录的id，如果id为空，则默认查询所有
     * @param id
     * @return
     */
    @Override
    public List<OrganizationDo> findTree(String id) {
        QueryWrapper<OrganizationDo> queryWrapper=new QueryWrapper<>();
        if (!StringUtils.isBlank(id)){
            queryWrapper.eq("id",Long.valueOf(id));
        }
        //根据id获取组织结构集合，如果id为空，则获取所有的组织结构
        List<OrganizationDo> organizationDoList =this.baseMapper.selectList(queryWrapper);
        if (CollectionUtils.isEmpty(organizationDoList)) {
            return null;
        }
        return parentAndChildren(organizationDoList);
    }

    /**
     * 根据id批量修改状态
     * @param organizationDoSet
     * @return
     */
    @Override
    public int modifyOrganizationByIds(Set<OrganizationDo> organizationDoSet) {
        //修改状态之前将所有状态为已选中的数据状态改为未选中
        QueryWrapper<OrganizationDo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("selected",AttributeStatusConstant.ORGANIZATION_SELECTED_YES);
        List<OrganizationDo> organizationDoList = this.baseMapper.selectList(queryWrapper);
        if (CollectionUtils.isNotEmpty(organizationDoList)) {
            for (OrganizationDo organizationDo : organizationDoList) {
                organizationDo.setSelected(AttributeStatusConstant.ORGANIZATION_SELECTED_NO);
                this.baseMapper.updateById(organizationDo);
            }
        }
        //执行修改操作
        int selectedCount=0;
        OrganizationDo organizationDo=new OrganizationDo();
        if (CollectionUtils.isNotEmpty(organizationDoSet)) {
            for (OrganizationDo aDo : organizationDoSet) {
                int updateById = this.baseMapper.updateById(aDo);
                selectedCount=selectedCount+updateById;
            }
        }
        return selectedCount;
    }

    /**
     * 组装父子组件
     * @param organizationDoList
     * @return
     */
    private List<OrganizationDo> parentAndChildren(List<OrganizationDo> organizationDoList){
        //顶层父组件
        List<OrganizationDo> rootList=new ArrayList<>();
        //非顶层父组件
        List<OrganizationDo> bodyList=new ArrayList<>();
        for (OrganizationDo organizationDo : organizationDoList) {
            //如果该组织结构父级id为空，说明此结构为顶层父结构，将其添加到父结构集合中
            if (null== organizationDo.getParentId()) {
                rootList.add(organizationDo);
            }else{
                //反之，说明此结构为子组织结构，将其添加到子组织结构集合中
                bodyList.add(organizationDo);
            }
        }
        return getTree(rootList,bodyList);
    }

    public List<OrganizationDo> getTree(List<OrganizationDo> rootList, List<OrganizationDo> bodyList){
        if (!CollectionUtils.isEmpty(bodyList)) {
            //声明一个map,用来过滤已操作过的数据
            Map<Long,Long> map=new HashMap<>(bodyList.size());
            /**
             * 采用forEach+lambda(java8及以后可以使用)，与一下代码有相同效果
             * for (Organization organization : rootList) {
             *     getChild(organization,bodyList,map);
             * }
             */
            rootList.forEach(organization->getChild(organization,bodyList,map));
            return rootList;
        }else {
            return rootList;
        }
    }

    private void getChild(OrganizationDo organizationDo, List<OrganizationDo> bodyList, Map<Long,Long> map){
        List<OrganizationDo> childList=new ArrayList<>();
        bodyList.stream().filter(c->!map.containsKey(c.getId()))
                         .filter(c->c.getParentId().equals(organizationDo.getId()))
                         .forEach(c->{
                             map.put(c.getId(),c.getParentId());
                             getChild(c,bodyList,map);
                             childList.add(c);
                         });
       organizationDo.setChildren(childList);
    }

}
