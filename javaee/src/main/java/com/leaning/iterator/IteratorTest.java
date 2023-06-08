package com.leaning.iterator;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: zuowenzhi 2023/5/25 created
 * @Description: com.leaning.iterator
 * @version: 1.0
 */

public class IteratorTest {
    @Test
    public void setIterator(){
        HashSet<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key);
//            set.remove(key);
            iterator.remove();
            System.out.println(set.size());
        }

    }

    @Test
    public void mapIterator(){
        Map<String,String> map = new HashMap<>();
        map.put("1","111");
        map.put("2","222");
        map.put("3","333");
        map.put("4","444");
        map.put("5","555");
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key);
//            set.remove(key);
            if(key.equals("4")){
                iterator.remove();
            }else {
                key="1-"+key;
            }
        }
        System.out.println(map);

        System.out.println(map.size());

    }
}


