package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teachers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Teacher extends User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String formacao;
    @Column(unique = true)
    private String matricula;

    @OneToMany(mappedBy = "teacher")
    private List<Team> teams;

    public Teacher(String formacao, String matricula) {
        this.formacao = formacao;
        this.matricula = matricula;
    }

    public Teacher(){

    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
