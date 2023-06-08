package com.leaning.statemachine.service;

import com.leaning.statemachine.entity.Order;

/**
 * @author: zuowenzhi 2023/6/6 created
 * @Description: com.leaning.statemachine.service
 * @version: 1.0
 */

public interface OrderService {
    Order create(Order order);

    Order pay(Long id);

    Order receive(Long id);

    Order deliver(Long id);

    Order getById(Long id);
}

