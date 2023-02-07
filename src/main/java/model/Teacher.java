package model;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Teacher extends User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String formacao;

    public Teacher(String formacao){
        this.formacao = formacao;
    }

    public Teacher(){

    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

}
