package com.leaning.service.impl;

import com.leaning.service.OrderService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.protocol.rest.support.ContentType;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;

//@Path("test")
@DubboService(protocol = {"dubbo","rest"})
@Service
public class OrderServiceImpl implements OrderService {
//    @POST
//    @Path("/test")
//    @Produces({ContentType.APPLICATION_JSON_UTF_8,ContentType.TEXT_PLAIN_UTF_8})
    @Override
    public String getOrder(Long orderId) {
        System.out.println("success: id="+orderId);
        return "success: id="+orderId;
    }
//
//    @GET
//    @Path("/test")
//    @Produces({ContentType.APPLICATION_JSON_UTF_8,ContentType.TEXT_PLAIN_UTF_8})
    @Override
    public String getOrderById(@QueryParam("id") Long id) {

        return "success-getOrderById: id="+id;
    }
}