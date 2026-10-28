package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
* Demo 2 - only tested the "happy path": valid input that returns a sum.
* In this demo we test the "unhappy path": input that should make the code fail.
* A good unit test checks not only THAT the code fails, but that it fails in the RIGHT way.
* */
public class StringCalculatorDemo3Test {

    private final StringCalculatorDemo3 calculator = new StringCalculatorDemo3();

    //The happy path from Demo 2, kept here so we can compare it with the unhappy-path tests below.
    @ParameterizedTest(name = "add(\"{0}\") = {1}")
    @CsvSource(delimiter = '|', value = {
            "''    | 0",
            "1     | 1",
            "1,2   | 3",
    })
    void sumsCommaSeparatedNumbers(String input, int expected) {
        assertThat(calculator.add(input)).isEqualTo(expected);
    }

    //The tests below do NOT go in the @CsvSource table above: they check for an exception instead of a return value.
    //Parameterized tests work best when every row is checked in exactly the same way.

    //assertThatThrownBy takes a lambda, so AssertJ can run the code itself and catch the exception.
    //If NO exception is thrown, the test fails.
    //We check the exception type AND the message, since the message is what the user sees.
    @Test
    void negativeNumberIsRejected() {
        assertThatThrownBy(() -> calculator.add("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Negatives not allowed: -1");
    }

    //A separate test for a separate rule: the message lists EVERY negative, not just the first one.
    //Keeping one rule per test means a failing test name tells you exactly which rule broke.
    @Test
    void allNegativeNumbersAreListedInTheMessage() {
        assertThatThrownBy(() -> calculator.add("1,-2,3,-4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Negatives not allowed: -2, -4");
    }
}
