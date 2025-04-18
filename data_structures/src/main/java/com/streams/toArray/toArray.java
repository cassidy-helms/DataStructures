package com.streams.toArray;

import java.util.ArrayList;
import java.util.List;

import com.streams.Employee;

public class toArray {
    public static void main(String[] args) {
        List<Employee> employeesList = new ArrayList<>();
        employeesList.add(new Employee(1, "John Doe", 10000.00));
        employeesList.add(new Employee(2, "Jim Smith", 20000.00));
        employeesList.add(new Employee(3, "Jane Williams", 30000.00));

        Employee[] employeesArr = employeesList.stream().toArray(Employee[]::new);

        for(Employee employee : employeesArr) {
            System.out.println(employee.toString());
        }
    }
}
