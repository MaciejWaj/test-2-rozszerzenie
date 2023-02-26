package pl.kurs.test2rozszerzenie.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kurs.test2rozszerzenie.execution.Execution;


@Service
public class ExecutionImpl implements Execution {


    public OperationHistoryService operationHistoryService;

    public ExecutionImpl() {
    }

    @Autowired
    public ExecutionImpl(OperationHistoryService operationHistoryService) {
        this.operationHistoryService = operationHistoryService;
    }

    @Override
    public double evaluateAndSave(String expression) {
        double result = MathService.evaluate(expression);
        operationHistoryService.saveToDataBase(expression, result);
        return result;
    }
}
