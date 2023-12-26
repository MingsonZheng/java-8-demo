package com.zzm.streamapi;

import com.zzm.methodreferences.Employee;
import com.zzm.methodreferences.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Stream的终止操作
 *
 * @author Mingson
 * @version 1.0
 */
public class StreamAPITest2 {

    // 1-匹配与查找
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();

        // allMatch(Predicate p) -- 检查是否匹配所有元素。
        // 练习:是否所有的员工的年龄都大于18
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println("allMatch=" + allMatch);

        // anyMatch(Predicate p) -- 检查是否至少匹配一个元素。
        // 练习:是否存在员工的工资大于 10000
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println("anyMatch=" + anyMatch);

        // noneMatch(Predicate p)-- 检查是否没有匹配的元素。
        // 练习:是否存在员工姓“雷”
        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println("noneMatch=" + noneMatch);

        // findFirst -- 返回第一个元素
        Optional<Employee> findFirst = employees.stream().findFirst();
        System.out.println("findFirst=" + findFirst);

        // findAny -- 返回当前流中的任意元素
        Optional<Employee> findAny = employees.stream().findAny();
        System.out.println("findAny=" + findAny);
        Optional<Employee> findAny2 = employees.parallelStream().findAny();
        System.out.println("findAny2=" + findAny2);
    }

    @Test
    public void test2() {
        List<Employee> employees = EmployeeData.getEmployees();

        // count -- 返回流中元素的总个数
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println("count=" + count);

        // max(Comparator c) -- 返回流中最大值
        // 练习:返回最高的工资:
        Stream<Double> salaryStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> max = salaryStream.max(Double::compare);
        System.out.println("max=" + max);

        // min(Comparator c) -- 返回流中最小值
        // 练习:返回最低工资的员工
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println("min=" + min);

        System.out.println("**********************");

        // forEach(Consumer c) 内部选代
        employees.stream().forEach(System.out::println);

        System.out.println("**********************");

        // 使用集合的遍历操作
        employees.forEach(System.out::println);
    }
}
