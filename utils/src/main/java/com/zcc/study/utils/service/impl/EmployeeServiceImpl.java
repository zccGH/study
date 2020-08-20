package com.zcc.study.utils.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcc.study.utils.domain.EmployeeDo;
import com.zcc.study.utils.mapper.EmployeeMapper;
import com.zcc.study.utils.service.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName EmployeeServiceImpl
 * @Description: 员工业务接口类
 * @Author chengcheng.zhao01
 * @Date 2020/8/17
 * @Version V1.0
 **/
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, EmployeeDo> implements EmployeeService {

    /**
     * 根据部门Id查询该部门员工
     * @param parentId
     * @return
     */
    @Override
    public List<EmployeeDo> getEmployeeByParentId(String parentId) {
        QueryWrapper<EmployeeDo> queryWrapper=new QueryWrapper<>();
        if (!StringUtils.isBlank(parentId)) {
            queryWrapper.eq("parent_id",Long.valueOf(parentId));
        }
        return this.baseMapper.selectList(queryWrapper);
    }
}
