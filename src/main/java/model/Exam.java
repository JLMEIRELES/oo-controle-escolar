package model;

import javax.persistence.*;

@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Double exam_grade;

    @Column
    private int peso;

    @Column
    private Boolean avaliada;

    public Exam(int id, Double exam_grade, int peso, Boolean avaliada) {
        this.id = id;
        this.exam_grade = exam_grade;
        this.peso = peso;
        this.avaliada = avaliada;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setExamGrade(Double exam_grade) {
        this.exam_grade = exam_grade;
    }

    public Double getExamGrade() {
        return exam_grade;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }

    public void setAvaliada(Boolean avaliada) {
        this.avaliada = avaliada;
    }

    public String getAvaliada() {
        return avaliada;
    }

    @ManyToOne
    private Subject subject;
}
