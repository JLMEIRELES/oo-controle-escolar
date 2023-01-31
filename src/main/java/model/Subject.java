package model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String subject_code;

    @Column
    private String subject_name;

    @Column
    private int class_hours;

    @OneToMany(mappedBy = "subject")
    private Set<Exam> exam;

    public Subject(String subject_code, String subject_name, int class_hours) {
        this.subject_code = subject_code;
        this.subject_name = subject_name;
        this.class_hours = class_hours;
    }

    public String getSubjectCode() {
        return subject_code;
    }

    public void setSubjectCode(String subject_code) {
        this.subject_code = subject_code;
    }

    public String getSubjectName() {
        return subject_name;
    }

    public void setSubjectName(String subject_name) {
        this.subject_name = subject_name;
    }

    public int getClassHours() {
        return class_hours;
    }

    public void setClassHours(int class_hours) {
        this.class_hours = class_hours;
    }
}
