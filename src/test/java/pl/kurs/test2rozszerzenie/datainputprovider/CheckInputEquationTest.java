package pl.kurs.test2rozszerzenie.datainputprovider;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.kurs.test2rozszerzenie.exception.InvalidEquationFormatException;
import pl.kurs.test2rozszerzenie.exception.UnknownOperatorException;

import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
class CheckInputEquationTest {


    @InjectMocks
    private CheckInputEquation checkInputEquation;

    @Test
    void shouldThrowInvalidEquationFormatExceptionForNullExpression() {
        String expression = null;
        assertThrows(InvalidEquationFormatException.class, () -> checkInputEquation.checkExpressionIsCorrect(expression));
    }

    @Test
    void shouldThrowUnknowOperatorExceptionForExpression() {
        String expression = "1 + + 2";
        assertThrows(UnknownOperatorException.class, () -> checkInputEquation.checkExpressionIsCorrect(expression));
    }

    @Test
    void shouldThrowUnknownOperatorExceptionForInvalidOperatorInExpression() {
        String expression = "1 + 2 @ 3";
        assertThrows(UnknownOperatorException.class, () -> checkInputEquation.checkExpressionIsCorrect(expression));
    }


    @Test
    void shouldThrowInvalidEquationFormatExceptionIfExpressionNotStartWithNumber() {
        String expression = "+ 3 + 2";
        assertThrows(InvalidEquationFormatException.class, () -> checkInputEquation.checkExpressionIsCorrect(expression));
    }

}