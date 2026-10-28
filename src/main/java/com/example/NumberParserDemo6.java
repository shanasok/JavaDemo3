package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/*
* Demo 6 - parsing grew big enough to deserve its own class.
* In Demo 5 this was a private parse() method inside the calculator, tested only through add().
* Supporting custom delimiters made it more complicated, so we extracted it into a class with a PUBLIC parse() method.
* Now NumberParserDemo6Test can test the parsing rules directly - no reflection, no "public just for testing".
* */
public class NumberParserDemo6 {

    private static final String DEFAULT_DELIMITERS = "[,\n]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";

    public List<Integer> parse(String numbers) {
        String delimiters = DEFAULT_DELIMITERS;
        String body = numbers;
        if (numbers.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int endOfHeader = numbers.indexOf('\n');
            //Pattern.quote makes the delimiter a literal: without it, split(".") would treat "." as "any character".
            delimiters = Pattern.quote(numbers.substring(CUSTOM_DELIMITER_PREFIX.length(), endOfHeader));
            body = numbers.substring(endOfHeader + 1);
        }
        return Arrays.stream(body.split(delimiters))
                .map(Integer::parseInt)
                .toList();
    }
}
