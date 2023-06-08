package com.leaning.statemachine.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author: zuowenzhi 2023/6/6 created
 * @Description: com.leaning.statemachine.entity
 * @version: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_order")
public class Order {

    /**
     * 主键ID
     */
    @TableId(type= IdType.INPUT)
    private Long id;
    /**
     * 订单编码
     */
    private String orderCode;
    /**
     * 订单状态
     */
    private Integer status;
    /**
     * 订单名称
     */
    private String name;
    /**
     * 价格
     */
    private Double price;
    /**
     * 删除标记，0未删除  1已删除
     */
    private Integer deleteFlag;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    /**
     * 创建人
     */
    private String createUserCode;
    /**
     * 更新人
     */
    private String updateUserCode;
    /**
     * 版本号
     */
    private Integer version;
    /**
     * 备注
     */
    private String remark;
}

