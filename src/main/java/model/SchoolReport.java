package model;

import javax.persistence.*;

@Entity
@Table(name = "school_report")
public class SchoolReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer diasLetivos;
    private Integer faltas;
    private String cargaHoraria;

    @OneToOne(mappedBy = "schoolReport")
    @PrimaryKeyJoinColumn
    private Student student;

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
