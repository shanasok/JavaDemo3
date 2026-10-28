# TDD & Unit Testing Demo: String Calculator

A step-by-step demo of **Test-Driven Development (TDD)** and unit testing in Java,
built around the classic *String Calculator* kata.

## Why Maven?

The company this course is taught at uses **Maven** as its build tool, so this demo uses
Maven too. That way, everything you see here (the project layout, the `pom.xml`, and running
tests with `mvn test`) carries straight over to the projects you work on day to day.

You don't need Maven installed. The project includes the **Maven Wrapper** (`mvnw` / `mvnw.cmd`),
which downloads the correct Maven version the first time you run it.

## Requirements

- Java 17 or newer

## Running the tests

```bash
./mvnw test        # macOS / Linux
mvnw.cmd test      # Windows
```

In IntelliJ, you can also click the green arrow next to a test class or method.

> **Tip:** if you rename or delete a test class and get a confusing `ClassNotFoundException`,
> run `./mvnw clean test`. An old compiled copy of the class is still sitting in `target/`.

## The TDD cycle

1. 🔴 **Red**: write a small test for behaviour that doesn't exist yet. Run it and watch it fail.
2. 🟢 **Green**: write the *simplest* code that makes the test pass. Hard-coding is allowed!
3. 🔵 **Refactor**: clean up the test or production code while keeping all tests green.

Repeat in small steps. Each test adds one new requirement.

## The demos

Each demo is a **pair of classes**: a test class in `src/test/java` and the production class it
drives in `src/main/java`. Open them side by side. The production code in each demo is
**only just enough** to make its tests pass, and nothing more.

| Demo | Test class | Production class | What it teaches |
|------|------------|------------------|-----------------|
| 1a | `StringCalculatorDemo1aTest` | `StringCalculatorDemo1a` | The first test: `""` → 0. The code just returns `0`, which is "fake it till you make it". |
| 1b | `StringCalculatorDemo1bTest` | `StringCalculatorDemo1b` | A second test (`"1"` → 1) shows the fake isn't enough, so real code appears. |
| 1c | `StringCalculatorDemo1cTest` | `StringCalculatorDemo1c` | A third test (`"1,2"` → 3) forces splitting and summing. The tests are getting repetitive... |
| 2 | `StringCalculatorDemo2Test` | `StringCalculatorDemo2` | **Refactoring the tests** with `@ParameterizedTest` + `@CsvSource`. The production code is unchanged, because there's no new behaviour. |
| 3 | `StringCalculatorDemo3Test` | `StringCalculatorDemo3` | **The unhappy path**: negative numbers throw an exception. Testing exceptions with `assertThatThrownBy`. |
| 4 | `StringCalculatorDemo4Test` | `StringCalculatorDemo4` | **Refactoring the code**: same tests as Demo 3, with the code split into small private methods. The tests are the safety net. |
| 5 | `StringCalculatorDemo5Test` | `StringCalculatorDemo5` | **A new requirement, test first**: newlines as delimiters. Thanks to Demo 4, it's a one-line change. |
| 6 | `StringCalculatorDemo6Test` + `NumberParserDemo6Test` | `StringCalculatorDemo6` + `NumberParserDemo6` | **Custom delimiters** (`"//;\n1;2"` → 3). Parsing grew too big for a private method, so it became its own class with its own tests. |

## Unit-testing ideas shown

- **Arrange / Act / Assert**: each test sets something up, calls one method and checks one outcome.
- **Descriptive test names**: a test name should say what the code does, e.g. `newlinesAreAlsoDelimiters`.
  JUnit 5 finds tests by the `@Test` annotation, so method names don't need to start with `test`.
- **Test class names matter in Maven**: Maven only runs classes named `*Test`, `Test*`, `*Tests`
  or `*TestCase`. A class called `StringCalculatorSpec` would run in IntelliJ but be skipped by `mvn test`.
- **Parameterized tests**: `@ParameterizedTest` + `@CsvSource` cover many examples without repeating code.
  They work best when every row is checked in the same way (Demo 2).
- **Testing exceptions**: `assertThatThrownBy(...)` checks both the exception type and its message (Demo 3).
- **Test behaviour, not implementation**: private methods are tested *through* the public method that
  uses them. That's why Demo 4's refactor needed no test changes. If a private method gets complicated
  enough that you want to test it directly, extract it into its own class instead (Demo 6).
- **Fluent assertions** with [AssertJ](https://assertj.github.io/doc/): `assertThat(actual).isEqualTo(expected)`,
  `assertThat(list).containsExactly(1, 2)`.

## Exercises: try it yourself

Continue the kata using TDD, starting from the Demo 6 classes. Write the failing test **first** for each one:

1. Numbers bigger than 1000 are ignored: `add("2,1001")` → `2`.
2. Delimiters can be any length: `add("//[***]\n1***2***3")` → `6`.
3. Allow multiple delimiters: `add("//[*][%]\n1*2%3")` → `6`.

Think about **where** each test belongs: in `StringCalculatorDemo6Test`, in `NumberParserDemo6Test`, or both?
