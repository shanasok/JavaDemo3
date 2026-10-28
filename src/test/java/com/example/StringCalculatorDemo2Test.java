package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/*
* Demo 1c - had similar tests where only the parameters changed.
* In this demo we use parameterized tests so that we only need to write the logic once and supply multiple sets of test data.
* */
public class StringCalculatorDemo2Test {

    private final StringCalculatorDemo2 calculator = new StringCalculatorDemo2();

    //CsvSource is a convenient way to supply multiple sets of parameters to a single test method.
    //In CsvSource, two single quotes represents an empty string, and the delimiter is set to | to avoid conflicts with commas in the input.
    //"add("{0}") = {1}" refers to the test name, where {0} and {1} are placeholders for the input and expected output values respectively.
    @ParameterizedTest(name = "add(\"{0}\") = {1}")
    @CsvSource(delimiter = '|', value = {
            "''    | 0",
            "1     | 1",
            "1,2   | 3",
    })
    void sumsCommaSeparatedNumbers(String input, int expected) {
        assertThat(calculator.add(input)).isEqualTo(expected);
    }
}
