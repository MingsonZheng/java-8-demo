package com.zzm.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @author Mingson
 * @version 1.0
 */
public class OptionalTest {

/**
 * Optional.of(T t) : 创建一个 Optional 实例，t必须非空;
 * Optional.empty() : 创建一个空的 Optional 实例
 * Optional.ofNullable(T t): t可以为null
 */

    @Test
    public void test1() {
        Girl girl = new Girl();
        Optional<Girl> optionalGirl = Optional.of(girl);
        System.out.println(optionalGirl);
    }

    @Test
    public void test2() {
        Girl girl = new Girl();
        girl = null;
        // Optional<Girl> optionalGirl = Optional.of(girl);// NullPointerException
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);
    }
}
