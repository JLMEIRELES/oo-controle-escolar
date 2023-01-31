package model;

import javax.persistence.*;

@Entity
@Table(name = "classroom")

public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String classroom_code;

    public void setClassroomCode(String classroom_code) {
        this.classroom_code = classroom_code;
    }

    public String getClassroomCode() {
        return classroom_code;
    }

    @ManyToOne
    private Building building;
}
