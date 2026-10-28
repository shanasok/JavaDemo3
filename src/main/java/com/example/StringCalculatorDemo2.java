package com.example;

/*
* Demo 2 - this code is IDENTICAL to StringCalculatorDemo1c.
* In Demo 2 we only refactored the TESTS (into a parameterized test); the behaviour being tested didn't change.
* No new behaviour tested = no new production code.
* */
public class StringCalculatorDemo2 {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (String number : numbers.split(",")) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
