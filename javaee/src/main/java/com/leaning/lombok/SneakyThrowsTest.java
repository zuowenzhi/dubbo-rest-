package com.leaning.lombok;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * @author: zuowenzhi 2023/5/23 created
 * @Description: com.leaning.lombok
 * @version: 1.0
 */

public class SneakyThrowsTest {

    @Test
    public void test() {
        test1();
    }

    @SneakyThrows
    public void test1() {
        throw new RuntimeException("test Exception");
    }
    /*
    @SneakyThrows做用就是编译之后,为这个方法添加一个try-catch的代码块,将抛出的异常捕获,然后再抛出去
    public void test1() {
        try {
            throw new RuntimeException("test Exception");
        } catch (Throwable var2) {
            throw var2;
        }
    }

    * */
}


