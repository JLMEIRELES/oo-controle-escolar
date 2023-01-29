package model;

import javax.persistence.*;

@Entity
@Table(name = "parents")
@PrimaryKeyJoinColumn(name = "user_id")
public class Parents extends User{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String filho;

    public Parents () {

    }

    public Parents (String filho) {
        this.filho = filho;
    }

    public String getFilho() {
        return filho;
    }

    public void setFilho(String filho) {
        this.filho = filho;
    }
}
