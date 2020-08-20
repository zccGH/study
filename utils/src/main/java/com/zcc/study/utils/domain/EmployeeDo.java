package com.zcc.study.utils.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Employee
 * @Description: 员工实体类
 * @Author chengcheng.zhao01
 * @Date 2020/8/17
 * @Version V1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDo implements Serializable {
    private static final long serialVersionUID = 7761566414965805117L;

    private Long id;
    /**
     * 员工头像
     */
    private String head;
    /**
     * 所属部门id
     */
    private Long parentId;
    /**
     * 员工姓名
     */
    private String empName;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 职位
     */
    private String position;
    /**
     * 办公地点
     */
    private String officeLocation;
    /**
     * 员工工号
     */
    private String jobNumber;
    @TableField(exist = false)
    private String createUser;
    @TableField(exist = false)
    private Date createDate;
    @TableField(exist = false)
    private String modifyUser;
    @TableField(exist = false)
    private Date modifyDate;


}
