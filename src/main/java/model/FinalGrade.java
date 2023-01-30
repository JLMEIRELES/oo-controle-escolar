package model;

import javax.persistence.*;

@Entity
@Table(name = "final_grade")
public class FinalGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
