/*******************************************************************************
 * 系统名称:  新一代支付系统天禄项目
 * 子系统名： easypay-tianlu-common
 * 模块名称： easypay-tianlu-common
 * 文件名称： Transition.java
 * 创建人：   pony
 * Copyright (c) 2022-2022,  All Rights Reserved.
 * 所有版权归易生支付有限公司所有
 *
 *
 * 注意： 本内容仅限于易生支付有限公司内部使用，禁止转发
 ******************************************************************************/

package com.leaning.statemachinetianlu;


import com.leaning.statemachinetianlu.impl.TransitionType;

public interface Transition<S, E, C> {
    /**
     * Gets the source state of this transition.
     *
     * @return the source state
     */
    State<S,E,C> getSource();

    void setSource(State<S, E, C> state);

    E getEvent();

    void setEvent(E event);

    void setType(TransitionType type);
    /**
     * Gets the target state of this transition.
     *
     * @return the target state
     */
    State<S,E,C> getTarget();

    void setTarget(State<S, E, C> state);

    /**
     * Gets the guard of this transition.
     *
     * @return the guard
     */
    Condition<C> getCondition();

    void setCondition(Condition<C> condition);

    Action<S,E,C> getAction();

    void setAction(Action<S, E, C> action);

    /**
     * Do transition from source state to target state.
     *
     * @return the target state
     */

    State<S, E, C> transit(C ctx, boolean checkCondition);
    /**
     * Verify transition correctness
     */
    void verify();
}
