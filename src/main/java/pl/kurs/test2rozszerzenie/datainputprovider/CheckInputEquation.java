package pl.kurs.test2rozszerzenie.datainputprovider;

import pl.kurs.test2rozszerzenie.exception.InvalidEquationFormatException;
import pl.kurs.test2rozszerzenie.exception.UnknownOperatorException;
import pl.kurs.test2rozszerzenie.operation.MathOperators;

public class CheckInputEquation {

    public static void checkExpressionIsCorrect(String expression) {
        if (expression == null || expression.chars().allMatch(Character::isWhitespace)) {
            throw new InvalidEquationFormatException("Expression can't be null or empty");
        }
        if (expression.chars().boxed().anyMatch(c -> (c == MathOperators.ADD.symbol
                || c == MathOperators.SUBTRACT.symbol|| c == MathOperators.MULTIPLY.symbol  || c == MathOperators.DIVIDE.symbol)
                && expression.indexOf(c) + 1 < expression.length()
                && expression.charAt(expression.indexOf(c) + 1) == c)) {
            throw new InvalidEquationFormatException("Two operators can't stand next to each other");
        }
        if (!Character.isDigit(expression.charAt(0)) || expression.charAt(0) == MathOperators.SUBTRACT.symbol) {
            throw new InvalidEquationFormatException("Equation must start with a number");
        }
        if (!expression.matches("^[0-9+\\-*/()_.]+$")) {
            throw new UnknownOperatorException("Equation must include only +, -, *, /");
        }
    }
}
