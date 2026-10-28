package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
* Demo 4 - REFACTOR: these tests are IDENTICAL to StringCalculatorDemo3Test.
* We are not adding behaviour, only cleaning up the production code, so no test changes are needed.
* The tests are our safety net: if they stay green, the refactor didn't break anything.
* */
public class StringCalculatorDemo4Test {

    private final StringCalculatorDemo4 calculator = new StringCalculatorDemo4();

    @ParameterizedTest(name = "add(\"{0}\") = {1}")
    @CsvSource(delimiter = '|', value = {
            "''    | 0",
            "1     | 1",
            "1,2   | 3",
    })
    void sumsCommaSeparatedNumbers(String input, int expected) {
        assertThat(calculator.add(input)).isEqualTo(expected);
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
