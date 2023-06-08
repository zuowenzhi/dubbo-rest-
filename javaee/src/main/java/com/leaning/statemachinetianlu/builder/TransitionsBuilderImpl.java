/*******************************************************************************
 * 系统名称:  新一代支付系统天禄项目
 * 子系统名： easypay-tianlu-common
 * 模块名称： easypay-tianlu-common
 * 文件名称： TransitionsBuilderImpl.java
 * 创建人：   pony
 * Copyright (c) 2022-2022,  All Rights Reserved.
 * 所有版权归易生支付有限公司所有
 *
 *
 * 注意： 本内容仅限于易生支付有限公司内部使用，禁止转发
 ******************************************************************************/

package com.leaning.statemachinetianlu.builder;


import com.leaning.statemachinetianlu.Action;
import com.leaning.statemachinetianlu.Condition;
import com.leaning.statemachinetianlu.State;
import com.leaning.statemachinetianlu.Transition;
import com.leaning.statemachinetianlu.impl.StateHelper;
import com.leaning.statemachinetianlu.impl.TransitionType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransitionsBuilderImpl<S,E,C> extends TransitionBuilderImpl<S,E,C> implements ExternalTransitionsBuilder<S,E,C> {
    /**
     * This is for fromAmong where multiple sources can be configured to point to one target
     */
    private List<State<S, E, C>> sources = new ArrayList<>();

    private List<Transition<S, E, C>> transitions = new ArrayList<>();

    public TransitionsBuilderImpl(Map<S, State<S, E, C>> stateMap, TransitionType transitionType) {
        super(stateMap, transitionType);
    }

    @Override
    public From<S, E, C> fromAmong(S... stateIds) {
        for(S stateId : stateIds) {
            sources.add(StateHelper.getState(super.stateMap, stateId));
        }
        return this;
    }

    @Override
    public On<S, E, C> on(E event) {
        for(State source : sources) {
            Transition transition = source.addTransition(event, super.target, super.transitionType);
            transitions.add(transition);
        }
        return this;
    }

    @Override
    public When<S, E, C> when(Condition<C> condition) {
        for(Transition transition : transitions){
            transition.setCondition(condition);
        }
        return this;
    }

    @Override
    public void perform(Action<S, E, C> action) {
        for(Transition transition : transitions){
            transition.setAction(action);
        }
    }
}
