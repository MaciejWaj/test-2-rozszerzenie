package pl.kurs.test2rozszerzenie.service;

import org.springframework.stereotype.Service;
import pl.kurs.test2rozszerzenie.exception.UnknownOperatorException;
import pl.kurs.test2rozszerzenie.operation.MathOperators;

import java.util.*;

@Service
public class MathService {


    public static double evaluate(String expression) {
        char[] digitAndOperatorList = expression.toCharArray();
        Stack<Double> values = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for (int i = 0; i < digitAndOperatorList.length; i++) {
            if (digitAndOperatorList[i] >= '0' && digitAndOperatorList[i] <= '9') {
                StringBuilder stringBuilder = new StringBuilder();
                while (i < digitAndOperatorList.length && digitAndOperatorList[i] >= '0' && digitAndOperatorList[i] <= '9')
                    stringBuilder.append(digitAndOperatorList[i++]);
                values.push(Double.parseDouble(stringBuilder.toString()));
                i--;
            } else if (digitAndOperatorList[i] == '(')
                operator.push(digitAndOperatorList[i]);
            else if (digitAndOperatorList[i] == ')') {
                while (operator.peek() != '(')
                    pushValues(values, operator);
                operator.pop();
            } else if (digitAndOperatorList[i] == MathOperators.SUBTRACT.symbol && (i == 0 || (digitAndOperatorList[i - 1] != ')' && !Character.isDigit(digitAndOperatorList[i - 1])))) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append('-');
                while (i + 1 < digitAndOperatorList.length && digitAndOperatorList[i + 1] >= '0' && digitAndOperatorList[i + 1] <= '9') {
                    stringBuilder.append(digitAndOperatorList[++i]);
                }
                values.push(Double.parseDouble(stringBuilder.toString()));
            } else if (MathOperators.isOperator(digitAndOperatorList[i])) {
                while (!operator.empty() && orderOfOperations(digitAndOperatorList[i],
                                operator.peek())) {
                    pushValues(values, operator);
                }
                operator.push(digitAndOperatorList[i]);
            }
        }
        while (!operator.empty())
            pushValues(values, operator);
            return values.pop();
    }

    private static void pushValues(Stack<Double> values, Stack<Character> operator) {
        double secondOperand = values.pop();
        double firstOperand = values.pop();
        values.push(applyOperation(operator.pop(), firstOperand, secondOperand));
    }

    public static boolean orderOfOperations ( char op1, char op2){
        if (op2 == '(' || op2 == ')')
            return false;
        return (op1 != MathOperators.MULTIPLY.symbol && op1 != MathOperators.DIVIDE.symbol) ||
                (op2 != MathOperators.ADD.symbol && op2 != MathOperators.SUBTRACT.symbol);
    }

    public static double applyOperation ( char op, double b, double a) throws ArithmeticException {
        if (a == 0 && op == MathOperators.DIVIDE.symbol || b == 0 && op == MathOperators.DIVIDE.symbol) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return MathOperators.getOperator(op).operation(b, a);
    }
}


