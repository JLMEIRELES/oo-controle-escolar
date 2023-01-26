package model;

import javax.persistence.*;

@Entity
@Table(name = "students")
@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User{


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricula;
    private String filiacao;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "school_report_id")
    private SchoolReport schoolReport;

    public Student(){

    }
    public Student(String matricula, String filiacao){
        this.matricula = matricula;
        this.filiacao = filiacao;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFiliacao() {
        return filiacao;
    }

    public void setFiliacao(String filiacao) {
        this.filiacao = filiacao;
    }


}


