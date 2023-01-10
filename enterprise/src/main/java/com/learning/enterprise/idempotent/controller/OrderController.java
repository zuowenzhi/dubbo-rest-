package com.learning.enterprise.idempotent.controller;

import com.learning.enterprise.idempotent.annotation.Idemptent;
import com.learning.enterprise.idempotent.entity.Order;
import com.learning.enterprise.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: zuowenzhi 2023/1/10 created
 * @Description: com.learning.enterprise.idempotent.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/genToken")
    public String genToken() {

        String token = String.valueOf(idWorker.nextId());
        redisTemplate.opsForValue().set(token, 0, 30, TimeUnit.MINUTES);
        return token;
    }


    @Idemptent
    @PostMapping("/genOrder2")
    public String genOrder2(@RequestBody Order order) {
        order.setId(String.valueOf(idWorker.nextId()));
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        int result = 1;//orderService.addOrder(order);
        if (result == 1) {
            System.out.println("success");
            return "success";
        } else {
            System.out.println("fail");
            return "fail";
        }
    }
}


