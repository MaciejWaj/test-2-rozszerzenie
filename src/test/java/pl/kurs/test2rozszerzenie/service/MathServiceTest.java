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
    public void evaluateExpressionWithNegativeResult() {
        String expression = "5-10";
        double expectedResult = -5;
        double actualResult = MathService.evaluate(expression);
        assertEquals(expectedResult, actualResult, 0.0);
    }


}