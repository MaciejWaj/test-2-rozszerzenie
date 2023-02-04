package pl.kurs.test2rozszerzenie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.kurs.test2rozszerzenie.service.MathService;



@SpringBootApplication
public class Test2RozszerzenieApplication {
    @Autowired
    private MathService service;

    public static void main(String[] args) {
        SpringApplication.run(Test2RozszerzenieApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doAfterStartUp() {
        service.run();
    }
}
