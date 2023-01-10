package com.learning.enterprise.idempotent.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: zuowenzhi 2023/1/10 created
 * @Description: com.learning.enterprise.idempotent.entity
 * @version: 1.0
 */
@Data
public class Order {

    private String id;
    private Date createTime;
    private Date updateTime;

}


