package com.zcc.study.utils.service;

import com.zcc.study.utils.UtilsApplicationTests;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OrganizationServiceTest extends UtilsApplicationTests {

    @Test
    void modifyOrganizationByIds() {
        Set<String> ids=new HashSet<>();
        ids.add("1");
        ids.add("2");
        //System.out.println(organizationService.modifyOrganizationByIds(ids));
    }
}