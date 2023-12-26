package com.zzm.streamapi;

import com.zzm.methodreferences.Employee;
import com.zzm.methodreferences.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 * Stream的中间操作
 *
 * @author Mingson
 * @version 1.0
 */
public class StreamAPITest1 {

    // 1-筛选与切片
    @Test
    public void test1() {
        List<Employee> list = EmployeeData.getEmployees();

        // filter(Predicate p) -- 接收 Lambda，从流中排除某些元寨。
        Stream<Employee> stream = list.stream();
        // 查询员工表中薪资大于7000的员工信息
        stream.filter(t -> t.getSalary() > 7000).forEach(System.out::println);

        System.out.println("**********************");

        // limit(long maxSize) -- 截断流，使其元素不超过给定数量。
        // IllegalStateException，stream 执行终止操作，之后，不会再被使用，需要重置
        // stream.limit(3).forEach(System.out::println);
        list.stream().limit(3).forEach(System.out::println);

        System.out.println("**********************");

        // skip(long n) -- 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补
        list.stream().skip(3).forEach(System.out::println);

        System.out.println("**********************");

        // distinct() -- 筛选，通过流所生成元素的 hashCode()equals()去除重复元素
        list.add(new Employee(1010, "刘强东", 40, 8000));
        list.add(new Employee(1010, "刘强东", 40, 8000));
        list.add(new Employee(1010, "刘强东", 40, 8000));
        list.add(new Employee(1010, "刘强东", 40, 8000));
        list.add(new Employee(1010, "刘强东", 40, 8000));

        list.stream().distinct().forEach(System.out::println);
    }
}
