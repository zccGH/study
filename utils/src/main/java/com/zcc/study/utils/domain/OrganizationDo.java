package com.zcc.study.utils.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName Organization
 * @Description: 组织实体类
 * @Author chengcheng.zhao01
 * @Date 2020/8/17
 * @Version V1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDo implements Serializable {
    private static final long serialVersionUID = -7935182879006897522L;

    private Long id;
    /**
     * 结构名称
     */
    private String label;
    /**
     * 描述
     */
    private String description;
    /**
     * 父节点id
     */
    private Long parentId;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 前端页面是否已保存对于该节点的选中状态 1-已选中  0-未选中
     */
    private Integer selected;
    private Date createTime;
    private Date modifyTime;
    /**
     * 子结构集合
     *  @TableField(exist = false)
     *  exist = false:表示该属性不为数据库表字段，但又是必须使用的。
     *  exist = true:表示该属性为数据库表字段。
     */
    @TableField(exist = false)
    private List<OrganizationDo> children;
}
