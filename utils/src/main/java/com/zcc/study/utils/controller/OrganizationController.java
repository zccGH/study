package com.zcc.study.utils.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.zcc.study.utils.config.HttpStatus;
import com.zcc.study.utils.domain.OrganizationDo;
import com.zcc.study.utils.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName OrganizationController
 * @Description: 树形组织结构接口封装
 * @Author chengcheng.zhao01
 * @Date 2020/8/17
 * @Version V1.0
 **/
@RestController
@RequestMapping("/organization")
public class OrganizationController extends BaseController {

    @Autowired
    OrganizationService organizationService;
    /**
     * 获取树形组织结构
     * @param id
     * @return
     */
    @GetMapping()
    public Map<String,Object> findTree(String id){
        List<OrganizationDo> organizationDoList = organizationService.findTree(id);
        return resultData(HttpStatus.SUCCESS,"请求成功", organizationDoList);
    }

    @PutMapping
    public Map<String,Object> modifyOrganizationStatus(@RequestBody Set<OrganizationDo> organizationDoSet){
        /**
         * 使用json方式从前端接收json数据，然后后端解析
         * List<OrganizationDo> list = JSONObject.parseArray(json,OrganizationDo.class);
         */
        int modifyOrganizationByIds = organizationService.modifyOrganizationByIds(organizationDoSet);
        if (0!=modifyOrganizationByIds){
            List<Integer> byIds=new ArrayList<>();
            byIds.add(modifyOrganizationByIds);
            return resultData(HttpStatus.SUCCESS,"保存成功",byIds);
        }else {
            return resultData(HttpStatus.SUCCESS,"保存失败",null);
        }
    };
}
