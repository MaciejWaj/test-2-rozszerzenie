package pl.kurs.test2rozszerzenie.datainputprovider;



import java.util.Scanner;

public class ConsoleEquationProvider implements InputEquationProvider {

    
    @Override
    public String getData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("state the equation");
        String equation = scanner.nextLine();
        String equationWithoutWhitespace = equation.replaceAll(" ", "");
        CheckInputEquation.checkExpressionIsCorrect(equation);
        return equationWithoutWhitespace;
    }


}
