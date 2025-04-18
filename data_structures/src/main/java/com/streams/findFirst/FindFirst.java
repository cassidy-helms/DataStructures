package com.streams.findFirst;

import java.util.ArrayList;
import java.util.List;

import com.streams.Employee;

public class FindFirst {
    public static void main(String[] args) {
        List<Employee> employeesList = new ArrayList<>();
        employeesList.add(new Employee(1, "John Doe", 10000.00));
        employeesList.add(new Employee(2, "Jim Smith", 20000.00));
        employeesList.add(new Employee(3, "Jane Williams", 30000.00));

        Employee firstEmp = employeesList.stream().filter(e -> e.getSalary() >= 20000).findFirst().orElse(null);
        System.out.println(firstEmp.toString());

        Employee firstEmpOver50k = employeesList.stream().filter(e -> e.getSalary() >= 50000).findFirst().orElse(null);
        System.out.println(firstEmpOver50k == null ? null : firstEmpOver50k.toString());
    }
}
