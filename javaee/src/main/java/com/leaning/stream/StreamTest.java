package com.leaning.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author: zuowenzhi 2023/5/22 created
 * @Description: com.leaning.stream
 * @version: 1.0
 */

public class StreamTest {
    @Test
    public void groupByTest(){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("张三7",17,170));
        users.add(new User("张三8",18,170));
        users.add(new User("张三9",18,170));
        users.add(new User("张三20",20,180));
        users.add(new User("李四17",17,170));
        users.add(new User("赵四20",20,180));

        Map<String, List<User>> collect = users.stream().collect(Collectors.groupingBy(e -> fetchGroupKey(e)));
        System.out.println(collect);


// 分组统计
//        Map<String, Long> countMap = users.stream().collect(Collectors.groupingBy(o -> o.getAge() + "_" + o.getHeight(), Collectors.counting()));
//
//        List<User> countRecords = countMap.keySet().stream().map(key -> {
//            String[] temp = key.split("_");
//            String productType = temp[0];
//            String country = temp[1];
//
//            record record = new User();
//            record.set("device_type", productType);
//            record.set("location", country;
//            record.set("count", countMap.get(key).intValue());
//            return record;
//        }).collect(Collectors.toList());

    }

    private static String fetchGroupKey(User user){
        return user.getAge() +"_"+ user.getHeight();
    }

    @Test
    public void sumOfListObject() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("张三7", 17, 170));
        users.add(new User("张三8", 18, 170));
        AtomicInteger sum = new AtomicInteger();
        users.stream().forEach(user -> sum.addAndGet(user.getHeight()));
        System.out.println(sum);


        int sum1 = users.stream().mapToInt(User::getHeight).sum();
        System.out.println(sum1);

        //reduce方法
        long reduce = users.stream().mapToLong(User::getHeight).reduce(0, Long::sum);
        System.out.println(reduce);
    }
}


