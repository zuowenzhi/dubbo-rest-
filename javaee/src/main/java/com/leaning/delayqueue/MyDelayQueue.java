package com.leaning.delayqueue;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.DelayQueue;

/**
 * @author: zuowenzhi 2023/5/4 created
 * @Description: com.leaning.delayqueue
 * @version: 1.0
 * 延迟任务的实现方式DelayQueue
 */
@Slf4j
public class MyDelayQueue {
    public static void main(String[] args) {
        DelayQueue<SanYouTask> sanYouTaskDelayQueue = new DelayQueue<>();
        new Thread(() -> {
            while (true) {
                try {
                    SanYouTask sanYouTask = sanYouTaskDelayQueue.take();
                    log.info("获取到延迟任务:{}", sanYouTask.getTaskContent());
                } catch (Exception e) {
                }
            }
        }).start();

        log.info("提交延迟任务");
        sanYouTaskDelayQueue.offer(new SanYouTask("三友的java日记5s", 1L));
        sanYouTaskDelayQueue.offer(new SanYouTask("三友的java日记3s", 1L));
        sanYouTaskDelayQueue.offer(new SanYouTask("三友的java日记8s", 10L));
    }
}


