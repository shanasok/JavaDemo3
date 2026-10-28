package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
* Demo 1b - add ONE new test: a single number returns itself.
* Run this against Demo 1a's hard-coded "return 0" and it fails (expected: 1, but was: 0).
* The new test proves the fake isn't enough, so now we have to write real code.
* */
public class StringCalculatorDemo1bTest {

    private final StringCalculatorDemo1b calculator = new StringCalculatorDemo1b();

    @Test
    void emptyStringReturnsZero() {
        assertThat(calculator.add("")).isEqualTo(0);
    }

    @Test
    void oneNumberReturnsItself() {
        assertThat(calculator.add("1")).isEqualTo(1);
    }
}
