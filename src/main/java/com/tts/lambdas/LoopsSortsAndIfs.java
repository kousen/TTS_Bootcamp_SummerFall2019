package com.tts.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LoopsSortsAndIfs {

    public static void useLoopsIfsAndSort(List<String> strings) {
        List<String> evens = new ArrayList<>();
        for (String s : strings) {
            if (s.length() % 2 == 0) {
                evens.add(s);
            }
        }

        Collections.sort(evens);

        for (String s : evens) {
            System.out.println(s);
        }
    }

    public static void useStreams(List<String> strings) {
        strings.stream()
                .filter(s -> s.length() % 2 == 0)
                .sorted()
                .forEach(x -> System.out.println(x));

        strings.forEach(System.out::println);
    }



    public static void main(String[] args) {
        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");
        LoopsSortsAndIfs.useLoopsIfsAndSort(strings);

        String[] words = "this is a sentence".split("\\s+");
    }
}
