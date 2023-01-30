package model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "building")

public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String building_name;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setBuildingName(String building_name) {
        this.building_name = building_name;
    }
    public String getBuildingName() {
        return building_name;
    }

    @OneToMany(mappedBy = "building")
    private Set<Classroom> classroom;
}
