package com.example;

/*
* Demo 1c - ONLY just enough code to pass StringCalculatorDemo1cTest:
*   ""    -> 0
*   "1"   -> 1
*   "1,2" -> 3
* No newlines, no negative-number checks: no test asks for them yet, so we don't write them.
* */
public class StringCalculatorDemo1c {

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
