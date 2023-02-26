package pl.kurs.test2rozszerzenie.operation;

import pl.kurs.test2rozszerzenie.exception.UnknownOperatorException;

import java.util.Arrays;


public enum MathOperators implements MathOperation  {
    ADD('+') {

        public double operation(double a, double b) {
            return a + b;
        }
    },
    SUBTRACT('-') {
        @Override
        public double operation(double a, double b) {
            return a - b;
        }
    },
    MULTIPLY('*') {
        @Override
        public double operation(double a, double b) {
            return a * b;
        }
    },
    DIVIDE('/') {
        @Override
        public double operation(double a, double b) {
            return a / b;
        }
    };

    public final char symbol;

    MathOperators(char symbol) {
        this.symbol = symbol;
    }


    public static MathOperators getOperator(char symbol) {
        for (MathOperators op : values()) {
            if (op.symbol == symbol) {
                return op;
            }
        }
        throw new UnknownOperatorException("Unknown operator symbol: " + symbol);
    }

    public static boolean isOperator(char operator) {
        return Arrays.stream(values()).anyMatch(o -> o.symbol == operator);
    }
}
