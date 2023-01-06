package com.leaning.service;

public interface OrderService {

    /**
     * 获取订单详情
     * @param orderId
     * @return
     */
    String getOrder(Long orderId);

    String getOrderById(Long orderId);
}