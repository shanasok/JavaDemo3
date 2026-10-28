package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
* Demo 1c - show that in each test I'm simply passing in a value and asserting the result.
* This is a good candidate for parameterized tests.
* */
public class StringCalculatorDemo1cTest {

    private final StringCalculatorDemo1c calculator = new StringCalculatorDemo1c();

    @Test
    void emptyStringReturnsZero() {
        assertThat(calculator.add("")).isEqualTo(0);
    }

    @Test
    void oneNumberReturnsItself() {
        assertThat(calculator.add("1")).isEqualTo(1);
    }

    @Test
    void twoNumbersAreAdded() {
        assertThat(calculator.add("1,2")).isEqualTo(3);
    }
}
