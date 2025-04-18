package com.streams.count;

import java.util.Arrays;
import java.util.List;

public class Count {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("turkey", "twinkle", "caribou", "apple", "turnip", "package", "tinsel");

        long count = strings.stream().filter(item -> item.startsWith("t")).count();
        System.out.println(count);
    }
}
