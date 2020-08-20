package com.zcc.study.utils.service;

import com.zcc.study.utils.UtilsApplicationTests;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDoServiceTest extends UtilsApplicationTests {

    @Test
    void findEmployeeByParentId() {
        employeeService.getEmployeeByParentId("35").forEach(System.out::println);
    }
}