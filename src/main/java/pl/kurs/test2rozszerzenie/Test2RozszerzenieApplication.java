package pl.kurs.test2rozszerzenie;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.kurs.test2rozszerzenie.datainputprovider.ConsoleEquationProvider;
import pl.kurs.test2rozszerzenie.execution.Execution;



@SpringBootApplication
public class Test2RozszerzenieApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Test2RozszerzenieApplication.class, args);

        Execution execution = ctx.getBean(Execution.class);


        ConsoleEquationProvider consoleEquationProvider = new ConsoleEquationProvider();

        double result = execution.evaluateAndSave(consoleEquationProvider.getData());
        System.out.println(result);

    }
}
