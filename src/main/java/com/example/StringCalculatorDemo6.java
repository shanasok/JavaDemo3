package com.example;

import java.util.List;
import java.util.stream.Collectors;

/*
* Demo 6 - new requirement: custom delimiters, e.g. "//;\n1;2" -> 3.
* All the parsing work moved into NumberParserDemo6, so the calculator just USES a parser.
* Compare with StringCalculatorDemo5: add() is unchanged apart from calling parser.parse(...).
* */
public class StringCalculatorDemo6 {

    private final NumberParserDemo6 parser = new NumberParserDemo6();

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        List<Integer> values = parser.parse(numbers);
        rejectNegatives(values);
        return values.stream().mapToInt(Integer::intValue).sum();
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
