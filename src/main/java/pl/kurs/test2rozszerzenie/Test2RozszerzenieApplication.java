package pl.kurs.test2rozszerzenie;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.kurs.test2rozszerzenie.datainputprovider.CheckInputEquation;
import pl.kurs.test2rozszerzenie.datainputprovider.ConsoleEquationProvider;
import pl.kurs.test2rozszerzenie.execution.Execution;



@SpringBootApplication
public class Test2RozszerzenieApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Test2RozszerzenieApplication.class, args);

        Execution execution = ctx.getBean(Execution.class);

        ConsoleEquationProvider consoleEquationProvider = new ConsoleEquationProvider();

        String end = "x";
        while(true) {
            String equation = consoleEquationProvider.getData();
            if(equation.equalsIgnoreCase(end)) {
                break;
            } else {
                CheckInputEquation.checkExpressionIsCorrect(equation);
                double result = execution.evaluateAndSave(equation);
                System.out.println(result);
            }
        }
        ctx.close();
    }
}
