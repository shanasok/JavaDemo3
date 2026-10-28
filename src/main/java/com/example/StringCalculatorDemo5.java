package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
* Demo 5 - ONLY just enough code to pass the new newline test in StringCalculatorDemo5Test:
*   "1\n2,3" -> 6
* Thanks to the Demo 4 refactor, all parsing lives in one place, so the change is a single line:
* split(",") became split(DELIMITERS), where DELIMITERS is a regex meaning "a comma OR a newline".
* */
public class StringCalculatorDemo5 {

    private static final String DELIMITERS = "[,\n]";

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        List<Integer> values = parse(numbers);
        rejectNegatives(values);
        return values.stream().mapToInt(Integer::intValue).sum();
    }

    private List<Integer> parse(String numbers) {
        return Arrays.stream(numbers.split(DELIMITERS))
                .map(Integer::parseInt)
                .toList();
    }

    private void rejectNegatives(List<Integer> values) {
        String negatives = values.stream()
                .filter(value -> value < 0)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }
    }
}
