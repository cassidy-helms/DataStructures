package com.streams.map;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.streams.Employee;

public class Map {
    public static void main(String[] args) {
        Integer[] employeeIds = { 1, 2, 3};

        List<Employee> employees = Stream.of(employeeIds)
            .map(id -> new Employee(id, "Employee " + id, 10000.00))
            .collect(Collectors.toList());

        employees.stream().forEach(e -> System.out.println(e.toString()));
    }
}
