package pl.kurs.test2rozszerzenie.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.test2rozszerzenie.model.OperationHistory;

import java.util.List;


public interface OperationHistoryRepository extends JpaRepository<OperationHistory, Long> {

     List<OperationHistory> findAll();
}