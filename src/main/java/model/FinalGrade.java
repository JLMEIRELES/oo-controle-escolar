package model;

import javax.persistence.*;

@Entity
@Table(name = "final_grade")
public class FinalGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Double final_grade;

    @Column
    private String mencao;

    public FinalGrade(){

    }

    public FinalGrade(Double final_grade, String mencao){
        this.final_grade = final_grade;
        this.mencao = mencao;
    }

    public void setFinalGrade(Double final_grade) {
        this.final_grade = final_grade;
    }

    public Double getFinalGrade() {
        return final_grade;
    }

    public void setMencao(String mencao) {
        this.mencao = mencao;
    }

    public String getMencao() {
        return mencao;
    }
}
