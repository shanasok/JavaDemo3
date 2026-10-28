package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
* Demo 4 - REFACTOR of StringCalculatorDemo3. Same behaviour, cleaner structure.
* In Demo 3, add() did three jobs in one loop: parse the input, collect negatives, and sum.
* Now each job has its own small, clearly named method, so add() reads like a summary of the steps.
* StringCalculatorDemo4Test is unchanged from Demo 3 and still passes - that's how we know the refactor is safe.
* */
public class StringCalculatorDemo4 {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        List<Integer> values = parse(numbers);
        rejectNegatives(values);
        return values.stream().mapToInt(Integer::intValue).sum();
    }

    private List<Integer> parse(String numbers) {
        return Arrays.stream(numbers.split(","))
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
