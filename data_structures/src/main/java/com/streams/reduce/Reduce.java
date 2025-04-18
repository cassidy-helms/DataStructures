package com.streams.reduce;

import java.util.Arrays;
import java.util.List;

public class Reduce {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog");

        String sentence = words.stream().reduce("", (acc, item) -> acc + " " + item);
        System.out.println(sentence);
    }
}
