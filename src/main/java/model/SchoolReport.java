package model;

import javax.persistence.*;

@Entity
@Table(name = "school_report")
public class SchoolReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private Integer diasLetivos;
    @Column
    private Integer faltas;


    @Column
    private String cargaHoraria;

    @OneToOne(mappedBy = "schoolReport")
    @PrimaryKeyJoinColumn
    private Student student;

    public SchoolReport(){

    }

    public SchoolReport(Integer diasLetivos, Integer faltas){
        this.diasLetivos = diasLetivos;
        this.faltas = faltas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Integer getDiasLetivos() {
        return diasLetivos;
    }

    public void setDiasLetivos(Integer diasLetivos) {
        this.diasLetivos = diasLetivos;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
