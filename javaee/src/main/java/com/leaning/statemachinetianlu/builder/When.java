/*******************************************************************************
 * 系统名称:  新一代支付系统天禄项目
 * 子系统名： easypay-tianlu-common
 * 模块名称： easypay-tianlu-common
 * 文件名称： When.java
 * 创建人：   pony
 * Copyright (c) 2022-2022,  All Rights Reserved.
 * 所有版权归易生支付有限公司所有
 *
 *
 * 注意： 本内容仅限于易生支付有限公司内部使用，禁止转发
 ******************************************************************************/

package com.leaning.statemachinetianlu.builder;


import com.leaning.statemachinetianlu.Action;

public interface When<S, E, C>{
    /**
     * Define action to be performed during transition
     *
     * @param action performed action
     */
    void perform(Action<S, E, C> action);
}