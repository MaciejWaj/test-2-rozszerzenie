package pl.kurs.test2rozszerzenie.datainputprovider;



import java.util.Scanner;

public class ConsoleEquationProvider implements InputEquationProvider {

        Scanner scanner = new Scanner(System.in);
    
    @Override
    public String getData() {
        System.out.println("To close calculator press x");
        System.out.println("state the equation");
        String equation = scanner.nextLine();
        String equationWithoutWhitespace = equation.replaceAll(" ", "");
        return equationWithoutWhitespace;
    }
}
