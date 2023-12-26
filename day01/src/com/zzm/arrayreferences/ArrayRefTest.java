package com.zzm.arrayreferences;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Function;

/**
 * 数组引用
 * 把数组看做是一个特殊的类，则写法与构造器引用一致。
 *
 * @author Mingson
 * @version 1.0
 */
public class ArrayRefTest {

    // Function中的R apply(T t)
    @Test
    public void test1() {
        Function<Integer, String[]> func1 = length -> new String[length];
        String[] arr1 = func1.apply(5);
        System.out.println(Arrays.toString(arr1));

        System.out.println("**********************");

        Function<Integer, String[]> func2 = String[] :: new;
        String[] arr2 = func2.apply(10);
        System.out.println(Arrays.toString(arr2));
    }
}
