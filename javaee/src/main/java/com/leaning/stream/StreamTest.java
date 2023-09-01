package com.leaning.stream;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author: zuowenzhi 2023/5/22 created
 * @Description: com.leaning.stream
 * @version: 1.0
 */

public class StreamTest {
    @Test
    public void groupByTest() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("张三7", 17, 170));
        users.add(new User("张三8", 18, 170));
        users.add(new User("张三9", 18, 170));
        users.add(new User("张三20", 20, 180));
        users.add(new User("李四17", 17, 170));
        users.add(new User("赵四20", 20, 180));

        //按照User类的多个字段进行分类,比如年龄和身高两个字段进行分组,fetchGroupKey方法里边定义了分组规则,
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

    private static String fetchGroupKey(User user) {
        return user.getAge() + "_" + user.getHeight();
    }

    @Test
    public void sumOfListObject() {
        //对user中的某个字段,进行累加,比如计算userList中的每个用户的存款金额,加起来一共是多少
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("张三7", 17, 170));
        users.add(new User("张三8", 18, 170));
        //一种方法是使用AtomicInteger
        AtomicInteger sum = new AtomicInteger();
        users.stream().forEach(user -> sum.addAndGet(user.getHeight()));
        System.out.println(sum);


        //一种是使用mapToInt或者mapToLong
        int sum1 = users.stream().mapToInt(User::getHeight).sum();
        System.out.println(sum1);

        //reduce方法
        long reduce = users.stream().mapToLong(User::getHeight).reduce(0, Long::sum);
        System.out.println(reduce);
    }

    /**
     * 根据集合中的元素的某个字段 进行提取,将这个集合中的某个字段提取出来,得到这个字段的集合
     */
    @Test
    public void groupByElementFiled() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("张三7", 17, 170));
        users.add(new User("张三8", 18, 170));
        users.add(new User("张三9", 18, 170));
        List<Integer> collect = users.stream().map(User::getAge).collect(Collectors.toList());
        System.out.println(collect);

        //根据某个字段去重,然后根据这个字段进行提取,得到不重复的集合,
        List<Integer> collect2 = users.stream().distinct().map(User::getAge).collect(Collectors.toList());
        System.out.println(collect2);
//        users.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(()->new TreeSet<>(Comparator.comparing(o->o.getHeight())))));
//
    }

    @Test
    public void testEnum() {
        CardStatus preSale = CardStatus.valuesOf("PRE_SALE");
        System.out.println(preSale);
    }

    @Test
    public void testRegex() {
        String regex = "^(?!0+$)\\d+$";
        System.out.println("00001000".matches(regex));

    }

    @Test
    public void testLocalDateTime() {
//        LocalDateTime dateTime1 = LocalDateTime.of(2023, 9, 1, 10, 30);
//        LocalDateTime dateTime2 = LocalDateTime.of(2023, 9, 1, 15, 45);
////        LocalDateTime dateTime1 = LocalDateTime.now();
////        LocalDateTime dateTime2 = LocalDateTime.now();
//        boolean isEqual = dateTime1.toLocalDate().isEqual(dateTime2.toLocalDate());
//        System.out.println("dateTime1 is equal to dateTime2: " + isEqual);

//        LocalDate date = LocalDate.parse("9999-12-31");
//        LocalDate startDate = LocalDate.of(1970, 1, 1);
//        long days = ChronoUnit.DAYS.between(startDate, date);
//        int dateValue = (int) days;
//
//        System.out.println("Date as integer: " + dateValue);

        int dateValue = 2932896; // 假设计算后的天数为10000

        LocalDate startDate = LocalDate.of(1970, 1, 1);
        LocalDate calculatedDate = startDate.plusDays(dateValue);

        System.out.println("Calculated Date: " + calculatedDate);
    }

}


