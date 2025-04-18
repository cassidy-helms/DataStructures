package com.streams.min;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Min {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        
        int min = nums.stream().min(Comparator.comparing(item -> item)).get();
        int max = nums.stream().max(Comparator.comparing(item -> item)).get();

        System.out.println(min);
        System.out.println(max);

        List<String> strings = Arrays.asList("cat", "salmon", "tree", "house", "rollercoaster");
        String minStr = strings.stream().min(Comparator.comparing(item -> item.length())).get();
        String maxStr = strings.stream().max(Comparator.comparing(item -> item.length())).get();

        System.out.println(minStr);
        System.out.println(maxStr);
    }
}
