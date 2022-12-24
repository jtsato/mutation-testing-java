package io.github.jtsato.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Calculator Test")
public class CalculatorTest {

    private final Calculator calculator;

    public CalculatorTest() {
        calculator = new Calculator();
    }

    @DisplayName("Successful to add two numbers")
    @ParameterizedTest
    @CsvSource({
        "5, 5, 10",
    })
    public void successfulToAddTwoNumbers(int first, int second, int expected) {
        // Arrange
        // Act
        int actual = calculator.add(first, second);

        // Assert
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("Successful to subtract two numbers")
    @ParameterizedTest
    @CsvSource({
        "1, 1, 0",
    })
    public void successfulToSubtractTwoNumbers(int first, int second, int expected) {
        // Arrange
        // Act
        int actual = calculator.subtract(first, second);

        // Assert
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("Successful to multiply two numbers")
    @ParameterizedTest
    @CsvSource({
        "1, 1, 1",
    })
    public void successfulToMultiplyTwoNumbers(int first, int second, int expected) {
        // Arrange
        // Act
        int actual = calculator.multiply(first, second);

        // Assert
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("Successful to divide two numbers")
    @ParameterizedTest
    @CsvSource({
        "1, 1, 1, 0",
    })
    public void successfulToDivideTwoNumbers(int dividend, int divisor, int expectedQuotient, int expectedRemainder) {
        // Arrange
        // Act
        int[] actual = calculator.divide(dividend, divisor);

        // Assert
        assertThat(actual[0]).isEqualTo(expectedQuotient);
        assertThat(actual[1]).isEqualTo(expectedRemainder);
    }

    @DisplayName("Fail to divide by zero")
    @ParameterizedTest
    @CsvSource({
        "1, 0",
    })
    public void failToDivideByZero(int dividend, int divisor) {
        // Arrange
        // Act
        final Exception exception =
                Assertions.assertThrows(Exception.class,
                        () -> calculator.divide(dividend, divisor));
        // Assert
        assertThat(exception).isInstanceOf(ArithmeticException.class);
        assertThat(exception.getMessage()).isEqualTo("/ by zero");
    }
}
