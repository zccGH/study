package com.zcc.study.utils.controller;

import com.zcc.study.utils.config.HttpStatus;
import com.zcc.study.utils.domain.EmployeeDo;
import com.zcc.study.utils.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName EmployeeController
 * @Description: 员工数据接口类
 * @Author chengcheng.zhao01
 * @Date 2020/8/17
 * @Version V1.0
 **/
@RestController
@RequestMapping("/employee")
public class EmployeeController extends BaseController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public Map<String,Object> findEmployeeList(String id){
        List<EmployeeDo> employeeDoList = employeeService.getEmployeeByParentId(id);
        return resultData(HttpStatus.SUCCESS,"查询成功", employeeDoList);
    };
}
