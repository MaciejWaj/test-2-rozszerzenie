package pl.kurs.test2rozszerzenie.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.kurs.test2rozszerzenie.exception.InvalidEquationFormatException;
import pl.kurs.test2rozszerzenie.exception.UnknownOperatorException;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MathServiceTest {

    @Mock
    private Stack<Double> mockValues;

    @Mock
    private Stack<Character> mockOperators;

    @InjectMocks
    private MathService mathService;

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testSimpleEvaluate() {
        String expression = "2+3*4";
        when(mockValues.pop()).thenReturn(4.0, 3.0, 2.0);
        when(mockOperators.pop()).thenReturn('+', '*');
        double result = MathService.evaluate(expression);
        assertEquals(14.0, result);
    }

    @Test
    public void testApplyOperation() throws UnknownOperatorException {
        char op = '/';
        double b = 4.0;
        double a = 2.0;
        double result = MathService.applyOperation(op, b, a);
        assertEquals(2.0, result);
    }

    @Test
    public void testOrderOfOperations() {
        String expression = "10-5*2+10/2";
        when(mockValues.pop()).thenReturn(10.0,5.0,2.0,10.0,2.0);
        when(mockOperators.pop()).thenReturn('-','*','+','/');
        double result = MathService.evaluate(expression);
        assertEquals(5.0, result);
    }

    @Test
    public void evaluateWithDivisionByZero() {
        String expression = "1 / 0";
        when(mockValues.pop()).thenReturn(1.0,0.0);
        when(mockOperators.pop()).thenReturn('/');
        try {
            MathService.evaluate(expression);
        } catch (ArithmeticException e) {
            assertEquals("Division by zero is not allowed", e.getMessage());
        }
    }

    @Test
    public void evaluateExpressionWithNegativeResult() {
        String expression = "5-10";
        when(mockValues.pop()).thenReturn(5.0,10.0);
        when(mockOperators.pop()).thenReturn('-');
        double result = MathService.evaluate(expression);
        assertEquals(-5.0, result);
    }


}