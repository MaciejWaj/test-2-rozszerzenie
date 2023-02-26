package pl.kurs.test2rozszerzenie.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kurs.test2rozszerzenie.datainputprovider.CheckInputEquation;
import pl.kurs.test2rozszerzenie.execution.Execution;
import pl.kurs.test2rozszerzenie.model.OperationHistory;
import pl.kurs.test2rozszerzenie.repository.OperationHistoryRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MathController {


    private Execution execution;
    private OperationHistoryRepository operationHistoryRepository;

    public MathController(Execution execution, OperationHistoryRepository operationHistoryRepository) {
        this.execution = execution;
        this.operationHistoryRepository = operationHistoryRepository;
    }

    @PostMapping("/calculate/{expression}")
    public ResponseEntity<Double> calculate(@PathVariable("expression") String expression) {
        CheckInputEquation.checkExpressionIsCorrect(expression);
        double result = execution.evaluateAndSave(expression);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/calculate/history")
    public ResponseEntity<List<OperationHistory>> getAll() {
        return ResponseEntity.ok(operationHistoryRepository.findAll());
    }
}



