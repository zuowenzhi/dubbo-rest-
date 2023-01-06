package com.leaning.service.mock;

import com.leaning.service.OrderService;

/**
 * @Auther: zuowenzhi 2022/12/28 created
 * @Description: com.leaning.service.mock
 * @version: 1.0
 */

public class OrderServiceMock implements OrderService {
    @Override
    public String getOrder(Long orderId) {
        return "";
    }

    @Override
    public String getOrderById(Long orderId) {
        return null;
    }
}


