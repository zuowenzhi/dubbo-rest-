package com.leaning.controller;

import com.leaning.service.OrderService;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
//@RequestMapping("/order")
public class OrderController {


    private final Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * 订单服务接口
     */
    @DubboReference(version = "1.0.0",
            timeout = 3000,
            methods = {@Method(name = "getOrder", timeout = 1000)},
            check = false,
            retries = 3 ,cluster = "failfast",
    loadbalance = "roundrobin",group = "mybatis",stub = "com.leaning.service.stub.OrderServiceStub")
    //group = "mybatis",在提供者的DubboService注解中配置了group,这里就可以选择对应的分组
    //使用存根 stub = "com.leaning.service.stub.OrderServiceStub",存根的全路径
    // 在发起远程dubbo调用之前,在存根类中做一些前置的工作
    private OrderService orderService;

    /**
     * cluster = "failfast" 集群容错策略
     * Failover 失败自动切换，当出现失败，重试其它服务器。通常用于读操作，但重试会带来更长延迟。可通过 retries="2" 来设置重试次数(不含第一次)。默认配置
     * Failfast 快速失败，只发起一次调用，失败立即报错。通常用于非幂等性的写操作，比如新增记录。
     * Failsafe 失败安全，出现异常时，直接忽略。通常用于写入审计日志等操作
     * Failback 失败自动恢复，后台记录失败请求，定时重发。通常用于消息通知操作。
     * Forking 并行调用多个服务器，只要一个成功即返回。通常用于实时性要求较高的读操作，但需要浪费更多服务资源。可通过 forks="2" 来设置最大并行数
     * https://cn.dubbo.apache.org/zh/docsv2.7/user/examples/fault-tolerent-strategy/
     */

    /**
     * 异步调用和异步执行
     * 异步调用:
     * 是服务消费方的异步调用,当controller收到请求,需要远程调用dubbo服务提供者时,是使用servlet的线程,还是使用新的线程调用
     *
     * 异步执行:
     * 是提供方的异步执行, dubbo的调用是dubbo框架提供的远程调用
     * 当服务提供方收到dubbo请求的之后,是使用接受请求的线程去调用service的实现类,还是使用新的线程去调用service的实现类
     */

    /**
     *  负载均衡策略
     *  AbstractLoadBalance的实现类,就是对应不同的策略
     */


    /**
     * 获取订单详情接口
     *
     * @param orderId
     * @return
     */
    @RequestMapping("/getOrder")
    @ResponseBody
    public String getOrder(Long orderId) {

        String result = null;
        try {
            result = orderService.getOrder(orderId);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

}