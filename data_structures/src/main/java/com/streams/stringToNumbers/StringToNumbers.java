package com.streams.stringToNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StringToNumbers {
    public static void main(String[] args) {
        // Long
        List<String> longsAsString = Arrays.asList("10000000000", "20000000000");

        LongStream longStream = longsAsString.stream().mapToLong(Long::parseLong);
        longStream.forEach(System.out::println);


        // Int
        List<String> intsAsString = Arrays.asList("1", "2");

        IntStream intStream = intsAsString.stream().mapToInt(Integer::parseInt);
        intStream.forEach(System.out::println);

        
        // Double
        List<String> doublesAsString = Arrays.asList("1.50", "2.50");

        DoubleStream doubleStream = doublesAsString.stream().mapToDouble(Double::parseDouble);
        doubleStream.forEach(System.out::println);
    }
}
