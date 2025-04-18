package com.streams.flatMap;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FlatMap {
    public static void main(String[] args) {
        List<List<String>> nestedNames = Arrays.asList(
            Arrays.asList("John", "Doe"),
            Arrays.asList("Jim", "Smith"),
            Arrays.asList("Jane", "Williams")
        );

        nestedNames.stream().flatMap(Collection::stream).forEach(System.out::println);
    }
}
