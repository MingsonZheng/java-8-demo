package com.zzm.methodreferences;

import java.util.ArrayList;
import java.util.List;

/**
 * 提供用于测试的数据
 *
 * @author Mingson
 * @version 1.0
 */
public class EmployeeData {

    public static List<Employee> getEmployees() {
        ArrayList<Employee> list = new ArrayList<>();

        list.add(new Employee(1001, "马化腾", 34, 6000.38));
        list.add(new Employee(1002, "马云", 12, 9876.12));
        list.add(new Employee(1003, "刘强东", 33, 3000.82));

        return list;
    }
}
