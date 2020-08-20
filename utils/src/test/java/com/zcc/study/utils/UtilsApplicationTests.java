package com.zcc.study.utils;

import com.zcc.study.utils.service.EmployeeService;
import com.zcc.study.utils.service.OrganizationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UtilsApplicationTests {

    @Autowired
    protected OrganizationService organizationService;

    @Autowired
    protected EmployeeService employeeService;


}
