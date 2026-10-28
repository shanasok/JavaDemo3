package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
* Demo 1a - the very first test. Start with the simplest possible case: an empty string returns 0.
* Write this test BEFORE StringCalculatorDemo1a exists - a test that doesn't compile counts as a failing (red) test.
* */
public class StringCalculatorDemo1aTest {

    private final StringCalculatorDemo1a calculator = new StringCalculatorDemo1a();

    @Test
    void emptyStringReturnsZero() {
        assertThat(calculator.add("")).isEqualTo(0);
    }
}
