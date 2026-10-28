package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
* Demo 6 - the calculator tests from Demo 5, plus ONE new test for custom delimiters.
* We still test the calculator as a whole: the user calls add(), not parse().
* The detailed parsing rules (like regex special characters) are tested in NumberParserDemo6Test.
* */
public class StringCalculatorDemo6Test {

    private final StringCalculatorDemo6 calculator = new StringCalculatorDemo6();

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
    void newlinesAreAlsoDelimiters() {
        assertThat(calculator.add("1\n2,3")).isEqualTo(6);
    }

    //The new test for this demo.
    @Test
    void customDelimiterCanBeDefined() {
        assertThat(calculator.add("//;\n1;2")).isEqualTo(3);
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
