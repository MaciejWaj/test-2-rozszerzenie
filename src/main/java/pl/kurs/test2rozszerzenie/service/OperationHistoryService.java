package pl.kurs.test2rozszerzenie.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kurs.test2rozszerzenie.model.OperationHistory;
import pl.kurs.test2rozszerzenie.repository.OperationHistoryRepository;

import java.time.LocalDateTime;

@Service
public class OperationHistoryService {


    public OperationHistoryRepository repository;

    @Autowired
    public OperationHistoryService(OperationHistoryRepository repository) {
        this.repository = repository;
    }

    public void saveToDataBase(String input, double result) {
        OperationHistory operationHistory = new OperationHistory();
        operationHistory.setExpression(input);
        operationHistory.setResult(result);
        operationHistory.setLocalDateTime(LocalDateTime.now());
        repository.save(operationHistory);
    }
}
