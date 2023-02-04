package pl.kurs.test2rozszerzenie.service;

import org.junit.jupiter.api.Test;
import pl.kurs.test2rozszerzenie.exception.InvalidEquationFormatException;

import static org.junit.jupiter.api.Assertions.*;

class MathServiceTest {


    @Test
    public void evaluateCorrectExpression() {
        String expression = "2 + 3 * 4 / 2";
        double expectedResult = 8.0;
        double actualResult = MathService.evaluate(expression);
        assertEquals(expectedResult, actualResult, 0.0);
    }

    @Test
    public void evaluateWithInvalidExpression() {
        String expression = "1 ++ 2";
        try {
            MathService.evaluate(expression);
        } catch (InvalidEquationFormatException e) {
            assertEquals("Two operators can't stand next to each other", e.getMessage());
        }
    }

    @Test
    public void evaluateWithExpressionContainingDecimalNumbers() {
        String expression = "2.5 + 3.5 * 4 / 2";
        double expectedResult = 13.0;
        double actualResult = MathService.evaluate(expression);
        assertEquals(expectedResult, actualResult, 0.0);
    }

    @Test
    public void evaluateWithDivisionByZero() {
        String expression = "1 / 0";
        try {
            MathService.evaluate(expression);
        } catch (ArithmeticException e) {
            assertEquals("Division by zero is not allowed", e.getMessage());
        }
    }

    @Test
    public void evaluateWithExpressionStartingWithOperator() {
        String expression = "+ 1 + 2";
        try {
            MathService.evaluate(expression);
        } catch (InvalidEquationFormatException e) {
            assertEquals("Equation must start with a number", e.getMessage());
        }
    }

}