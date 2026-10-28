package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
* Demo 5 - a NEW requirement: newlines can be used as delimiters, as well as commas.
* The TDD way: write the failing test FIRST. Run it against StringCalculatorDemo4 and it fails with
* NumberFormatException: For input string: "1\n2" - proof that the test checks something new.
* Then change the production code just enough to make it pass.
* */
public class StringCalculatorDemo5Test {

    private final StringCalculatorDemo5 calculator = new StringCalculatorDemo5();

    @ParameterizedTest(name = "add(\"{0}\") = {1}")
    @CsvSource(delimiter = '|', value = {
            "''    | 0",
            "1     | 1",
            "1,2   | 3",
    })
    void sumsCommaSeparatedNumbers(String input, int expected) {
        assertThat(calculator.add(input)).isEqualTo(expected);
    }

    //The new test. It's a plain @Test rather than a @CsvSource row: a "\n" inside the table
    //would print as a real line break in the test name and make the report hard to read.
    @Test
    void newlinesAreAlsoDelimiters() {
        assertThat(calculator.add("1\n2,3")).isEqualTo(6);
    }

    @Test
    void negativeNumberIsRejected() {
        assertThatThrownBy(() -> calculator.add("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Negatives not allowed: -1");
    }

    @Test
    void allNegativeNumbersAreListedInTheMessage() {
        assertThatThrownBy(() -> calculator.add("1,-2,3,-4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Negatives not allowed: -2, -4");
    }
}
