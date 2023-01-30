package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "class")

public class Class {
    @Column(name = "class_date")
    private LocalDate classDate;

    @Column(name = "class_time")
    private LocalTime classTime;
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
