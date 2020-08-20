package com.zcc.study.utils.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcc.study.utils.domain.EmployeeDo;

import java.util.List;

/**
 * @ClassName EmployeeService
 * @Description: 员工业务接口
 * @Author chengcheng.zhao01
 * @Date 2020/8/17
 * @Version V1.0
 **/
public interface EmployeeService extends IService<EmployeeDo> {

    /**
     * 根据员工部门id查询所有员工
     * @param parentId
     * @return
     */
    List<EmployeeDo> getEmployeeByParentId(String parentId);
}
