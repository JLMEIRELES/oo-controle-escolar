package model;

import javax.persistence.*;

@Entity
@Table(name = "class_attendance")

public class ClassAttendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private boolean attendance;

    public ClassAttendance(){

    }

    public ClassAttendance(boolean attendance){
        this.attendance = attendance;
    }

    public boolean isAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }
}

