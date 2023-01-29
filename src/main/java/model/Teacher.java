package model;

import javax.persistence.*;


@Entity
@Table(name = "Teachers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Teacher extends User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String formacao;

    public Teacher () {

    }

    public Teacher(String formacao) {
        this.formacao = formacao;
    }
    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }
}
