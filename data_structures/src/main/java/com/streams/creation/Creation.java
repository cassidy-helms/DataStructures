package com.streams.creation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.streams.Employee;

public class Creation {
    public static void main(String args[]) {
        Employee[] employeesArr = {
            new Employee(1, "John Doe", 10000.00),
            new Employee(2, "Jim Smith", 20000.00),
            new Employee(3, "Jane Williams", 30000.00)
        };

        // Stream from Existing Array
        Stream.of(employeesArr);

        List<Employee> employeesList = new ArrayList<>();

        // Stream from Existing List
        employeesList.stream();

        // Stream from Invidual Objects
        Stream.of(employeesArr[0], employeesArr[1], employeesArr[2]);

        Stream.Builder<Employee> streamBuilder = Stream.builder();
        streamBuilder.accept(employeesArr[0]);
        streamBuilder.accept(employeesArr[1]);
        streamBuilder.accept(employeesArr[2]);

        // Build Stream
        streamBuilder.build();
    }
}
