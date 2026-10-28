package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
* Demo 6 - tests for the newly extracted NumberParserDemo6 class.
* These tests check the parsing rules directly: they look at the LIST of numbers, not the sum.
* That makes failures easier to diagnose - "expected [1, 2] but was [12]" points straight at the parser.
* */
public class NumberParserDemo6Test {

    private final NumberParserDemo6 parser = new NumberParserDemo6();

    @Test
    void splitsOnCommas() {
        assertThat(parser.parse("1,2")).containsExactly(1, 2);
    }

    @Test
    void splitsOnNewlines() {
        assertThat(parser.parse("1\n2,3")).containsExactly(1, 2, 3);
    }

    //Custom delimiter format: "//" + delimiter + newline + numbers.
    @Test
    void supportsCustomDelimiter() {
        assertThat(parser.parse("//;\n1;2")).containsExactly(1, 2);
    }

    //An edge case that is easy to test here, but would be easy to miss when only testing through add().
    //"." means "any character" in a regex, so the parser must treat the delimiter as plain text.
    @Test
    void customDelimiterThatIsARegexSpecialCharacterIsTreatedAsPlainText() {
        assertThat(parser.parse("//.\n1.2")).containsExactly(1, 2);
    }
}
