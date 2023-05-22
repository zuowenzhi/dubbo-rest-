package com.leaning.stream;

import cn.hutool.core.util.NumberUtil;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Admin
 * @Auther: zuowenzhi 2022/12/23 created
 * @Description: com.leaning
 * @version: 1.0
 */

public class MyStreamDemo {
    public static void main(String[] args) {
//        User user1 = new User("111", "18", 180);
//        User user2 = new User("222", "18", 175);
//        User user3 = new User("333", "19", 170);
//
//        // stream流，创建的是动态数组，可以添加元素
//        List<User> userList = Stream.of(user1, user2, user3).collect(Collectors.toList());
//        List<String> collect = userList.stream().map(User::getName).collect(Collectors.toList());
//        show(userList);
//        show1(userList);
//        show2(userList);
//        show5(2);
//        demo();
        String a ="sdafdasdfsaf";
        String complementer = complementer(a);
        System.out.println(complementer);
    }

    private static void show5(int gap ) {
//      NumberUtil.generateRandomNumber(0,9,6)
//        int[] ints = NumberUtil.generateRandomNumber(0,9,6);
//
//        for (int anInt : ints) {
//            anInt
//            System.out.print(anInt);
//        }
        System.out.println(String.format("%0" + gap + "d", 0));
    }

    public static String complementer(String preCardInfo){
        if(preCardInfo.length()<75){
            int gap = 75-preCardInfo.length();
            String format = String.format("%0" + gap + "d", 0);
//            String randomNumber=NumberUtil.genLengthZero(gap);
            preCardInfo = preCardInfo+format;
        }
        return preCardInfo;
    }

    private static void show4() {
        HashMap<String, User> user1 = new HashMap<>();
        user1.put("type1",new User(1L,"jack"));
        user1.put("type1",new User(2L,"lucy"));
        user1.put("type1",new User(3L,"tom"));
        HashMap<String, User> user2 = new HashMap<>();
        user2.put("type1",new User(4L,"tom2"));

//        Stream<Map.Entry<String, User>> concat = Stream.concat(user1.entrySet().stream(), user2.entrySet().stream());
//        Map<String, User> collect = concat.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//        System.out.println(collect);
//        collect.forEach((k, v) -> System.out.println(k + "=:" + v));


    }

    private static void demo() {

//        LogStatus logStatus = LogStatus.valuesOf(2);
//        System.out.println(logStatus);
    }

    private static void show2(List<User> userList) {
        /**
         * 判断的条件里，任意一个元素成功，返回true;
         * 比如上面的userlList，我想判断是否有height > 175的：
         */
        boolean b = userList.stream().anyMatch(user -> user.getHeight() > 175);
        System.out.println(b);

        /**
         * allMatch：判断条件里的元素，所有的都是，返回true；
         * 比如上面的userlList，我想判断是否全部height > 175的：
         */
        boolean b1 = userList.stream().allMatch(user -> user.getHeight() > 175);
        System.out.println(b1);


    }

    private static void show1(List<User> userList) {
        //list转map
//        Map<String, User> userMap = new HashMap<>();
//        for (User user : userList) {
//            userMap.put(user.getName(), user);
//        }
        //stream流形式
        /**
         * 用Collectors的toMap方法转换List，一般会遇到两个问题。
         * （1）转换map，key重复问题；
         * 代码中使用(key1,key2)->key2表达式可以解决此类问题，如果出现重复的key就使用key2覆盖前面的key1,
         * 也可以定义成(key1,key2)->key1，保留key1,根据自己的业务场景来调整。
         * （2）空指针异常，即转为map的value是null。这个可以用filter过滤；
         */

        Map<String, User> userMap1 = userList.stream().collect(Collectors.toMap(User::getName, Function.identity(), (key1, key2) -> key2));
        List<User> userList1 = new ArrayList<>();
        for (String userName : userMap1.keySet()) {
            userList.add(userMap1.get(userName));
        }

        List<User> userList2 = userMap1.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());


    }

    private static void show(List<User> userList) {

// Stream流
//        List<String> userNameList = userList.stream().map(User::getName).collect(Collectors.toList());
//        System.out.println(userNameList);
        // 获取userName不为空的user的List
//        List<User> userList1 = userList.stream().filter(user-> user.getName() != null).collect(Collectors.toList());

        //分组,user对象,按照age进行分组,相同的分为一组,放到一个集合中,再将age作为key,list作为value,返回一个集合
//        Map<String, List<User>> map = userList.stream().collect(Collectors.groupingBy(User::getAge, Collectors.toList()));
//
//        System.out.println(map);

        //求和
        // int、double、long:
        double max = userList.stream().mapToDouble(User::getHeight).sum();

    }

}


