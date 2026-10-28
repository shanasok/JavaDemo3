package com.example;

/*
* Demo 1b - ONLY just enough code to pass StringCalculatorDemo1bTest:
*   ""  -> 0
*   "1" -> 1
* Now we need to tell an empty string apart from a number, so the empty-string check appears.
* No commas yet: no test has asked us to add two numbers.
* */
public class StringCalculatorDemo1b {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(numbers);
    }
}
