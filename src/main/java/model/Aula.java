package model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "aula")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "class_date")
    private LocalDate classDate;

    @Column(name = "class_time")
    private LocalTime classTime;

    public Aula(){

    }
    public Aula(LocalDate classDate, LocalTime classTime) {
        this.classDate = classDate;
        this.classTime = classTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClassDate(LocalDate classDate) {
        this.classDate = classDate;
    }

    public LocalDate getClassDate() {
        return classDate;
    }

    public void setClassTime(LocalTime classTime) {
        this.classTime = classTime;
    }

    public LocalTime getClassTime() {
        return classTime;
    }

}
