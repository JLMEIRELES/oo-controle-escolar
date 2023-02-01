package model;

import javax.persistence.*;

@Entity
@Table(name = "exam")
public class Exam{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Double exam_grade;

    @Column
    private int weight;

    @Column
    private Boolean evaluation;

    public Exam(){

    }
    public Exam(Double exam_grade, int weight, Boolean evaluation) {
        this.exam_grade = exam_grade;
        this.weight = weight;
        this.evaluation = evaluation;
    }

    public void setExamGrade(Double exam_grade) {
        this.exam_grade = exam_grade;
    }

    public Double getExamGrade() {
        return exam_grade;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void isEvaluation(Boolean evaluation) {
        this.evaluation = evaluation;
    }

    public Boolean getEvaluation() {
        return evaluation;
    }

    @ManyToOne
    private Subject subject;
}
