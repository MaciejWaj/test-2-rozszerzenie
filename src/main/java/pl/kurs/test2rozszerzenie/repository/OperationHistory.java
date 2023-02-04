package pl.kurs.test2rozszerzenie.repository;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.*;

@Entity
public class OperationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_operation")
    private Long id;
    @Column(name = "date")
    private LocalDate localDate;
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

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
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
        this.localDate = localDate;
        this.expression = expression;
        this.result = result;
    }
}