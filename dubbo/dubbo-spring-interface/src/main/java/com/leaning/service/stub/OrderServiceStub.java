package com.leaning.service.stub;

import com.leaning.service.OrderService;

/**
 * @Auther: zuowenzhi 2022/12/28 created
 * @Description: com.leaning.service.stub
 * @version: 1.0
 */

public class OrderServiceStub implements OrderService {

    private OrderService orderService;

    public OrderServiceStub(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String getOrder(Long orderId) {
        if(null!=orderId){
            String order = orderService.getOrder(orderId);
            return order;
        }else {
            return "参数校验错误";
        }
    }

    @Override
    public String getOrderById(Long orderId) {
        return null;
    }
}


