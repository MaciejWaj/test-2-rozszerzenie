package pl.kurs.test2rozszerzenie.model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
public class OperationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_operation")
    private Long id;
    @Column(name = "date")
    private LocalDateTime localDateTime;
    private String expression;
    private double result;

    public OperationHistory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public OperationHistory(LocalDate localDate, String expression, double result) {
        this.localDateTime = localDateTime;
        this.expression = expression;
        this.result = result;
    }
}