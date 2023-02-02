package model;

import javax.persistence.*;

@Entity
@Table(name = "students")
@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User{


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String matricula;
    @Column
    private String filiacao;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "school_report_id")
    private SchoolReport schoolReport;

    @OneToOne (mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Records records;

    public Student(){

    }
    public Student(String matricula, String filiacao){
        this.matricula = matricula;
        this.filiacao = filiacao;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


