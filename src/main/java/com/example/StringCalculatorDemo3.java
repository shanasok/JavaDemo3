package com.example;

import java.util.ArrayList;
import java.util.List;

/*
* Demo 3 - StringCalculatorDemo2 plus ONLY just enough code to pass the new unhappy-path tests:
*   "-1"        -> IllegalArgumentException("Negatives not allowed: -1")
*   "1,-2,3,-4" -> IllegalArgumentException("Negatives not allowed: -2, -4")
* We collect ALL negatives (not just the first) because a test demands it.
* */
public class StringCalculatorDemo3 {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        int sum = 0;
        List<String> negatives = new ArrayList<>();
        for (String number : numbers.split(",")) {
            int value = Integer.parseInt(number);
            if (value < 0) {
                negatives.add(number);
            }
            sum += value;
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + String.join(", ", negatives));
        }
        return sum;
    }
}
