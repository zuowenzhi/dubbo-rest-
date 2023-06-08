/*******************************************************************************
 * 系统名称:  新一代支付系统天禄项目
 * 子系统名： easypay-tianlu-common
 * 模块名称： easypay-tianlu-common
 * 文件名称： State.java
 * 创建人：   pony
 * Copyright (c) 2022-2022,  All Rights Reserved.
 * 所有版权归易生支付有限公司所有
 *
 *
 * 注意： 本内容仅限于易生支付有限公司内部使用，禁止转发
 ******************************************************************************/

package com.leaning.statemachinetianlu;


import com.leaning.statemachinetianlu.impl.TransitionType;

import java.util.Collection;
import java.util.List;

public interface State<S,E,C> {
    /**
     * Gets the state identifier.
     *
     * @return the state identifiers
     */
    S getId();

    String accept(Visitor visitor);

    /**
     * Add transition to the state
     * @param event the event of the Transition
     * @param target the target of the transition
     * @return
     */
    Transition<S,E,C> addTransition(E event, State<S, E, C> target, TransitionType transitionType);

    List<Transition<S,E,C>> getEventTransitions(E event);

    Collection<Transition<S,E,C>> getAllTransitions();
}
