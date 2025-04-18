package com.streams.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.streams.Employee;

public class Practice {
    public static void main(String[] args) {
        System.out.println(evenNumberSum(Arrays.asList(1, 2, 3, 4, 5)));
        System.out.println(countStringsLongerThan5(Arrays.asList("salamander", "table", "port", "bookcase", "milk", "brisk", "highway")));
        System.out.println(listSquared(Arrays.asList(1, 2, 3, 4, 5)));
        System.out.println(max(Arrays.asList(1, 2, 3, 4, 5)));
        System.out.println(concatenate(Arrays.asList("a", "b", "c", "d", "e")));
        System.out.println(uppercaseAndAlphabetize(Arrays.asList("salamander", "table", "port", "bookcase", "milk", "brisk", "highway")));
        System.out.println(average(Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5)));
        System.out.println(removeDuplicates(Arrays.asList("spoon", "fork", "knife", "spoon", "plate", "knife")));
        System.out.println(allEven(Arrays.asList(1, 2, 3, 4, 5)));
        System.out.println(allEven(Arrays.asList(2, 4, 6, 8, 10)));
        System.out.println(listContains(Arrays.asList("salamander", "table", "port", "bookcase", "milk", "brisk", "highway"), "milk"));
        System.out.println(listContains(Arrays.asList("salamander", "table", "port", "bookcase", "milk", "brisk", "highway"), "aardvark"));
        System.out.println(longestString(Arrays.asList("salamander", "table", "port", "bookcase", "milk", "brisk", "highway")));
        System.out.println(removeNulls(Arrays.asList("salamander", "table", null, "port", "bookcase", "milk", null, "brisk", "highway")));

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", 50000.0, "HR"));
        employees.add(new Employee(2, "Bob", 60000.0, "IT"));
        employees.add(new Employee(3, "Charlie", 55000.0, "Finance"));
        employees.add(new Employee(4, "David", 70000.0, "IT"));
        employees.add(new Employee(5, "Eva", 45000.0, "HR"));
        employees.add(new Employee(6, "Frank", 58000.0, "Finance"));
        System.out.println(groupByDepartment(employees));

        System.out.println(secondSmallest(Arrays.asList(1, 2, 3, 4, 5)));
    }

    private static int evenNumberSum(List<Integer> arr) {
        return arr.stream().filter(num -> num % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    private static long countStringsLongerThan5(List<String> arr) {
        return arr.stream().filter(str -> str.length() > 5).peek(System.out::println).count();
    }

    private static List<Integer> listSquared(List<Integer> arr) {
        return arr.stream().map(num -> num * num).collect(Collectors.toList());
    }

    public static int max(List<Integer> arr) {
        return arr.stream().mapToInt(Integer::intValue).max().getAsInt();
    }
    
    public static String concatenate(List<String> arr) {
        return arr.stream().collect(Collectors.joining());
    }

    public static List<String> uppercaseAndAlphabetize(List<String> arr) {
        return arr.stream().map(str -> str.toUpperCase()).sorted().collect(Collectors.toList());
    }

    public static double average(List<Double> arr) {
        return arr.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
    }

    public static List<String> removeDuplicates(List<String> arr) {
        return arr.stream().distinct().collect(Collectors.toList());
    }

    public static boolean allEven(List<Integer> arr) {
        return arr.stream().allMatch(num -> num % 2 == 0);
    }

    public static boolean listContains(List<String> arr, String word) {
        return arr.stream().anyMatch(num -> num.equals(word));
    }

    public static String longestString(List<String> arr) {
        return arr.stream().max(Comparator.comparing(str -> str.length())).get();
    }

    public static List<String> removeNulls(List<String> arr) {
        return arr.stream().filter(str -> str != null).collect(Collectors.toList());
    }

    public static Map<String, Optional<Employee>> groupByDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
    }

    public static int secondSmallest(List<Integer> arr) {
        return arr.stream().mapToInt(Integer::intValue).distinct().sorted().skip(1).findFirst().getAsInt();
    }
}
