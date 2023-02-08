package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String codigo;
    private String nome;
    @Column(name = "data_inicio")
    private Date dataInicio;
    @Column(name = "data_fim")
    private Date dataFim;
    private String turno;
    @Enumerated(EnumType.STRING)
    @Column(name = "class_type")
    private EnumTypeClass tipoTurma;
    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    public Team() {
    }

    public Team(String codigo, String nome, Date dataInicio, Date dataFim, String turno, EnumTypeClass tipoTurma) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.turno = turno;
        this.tipoTurma = tipoTurma;
    }

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public EnumTypeClass getTipoTurma() {
        return tipoTurma;
    }

    public void setTipoTurma(EnumTypeClass tipoTurma) {
        this.tipoTurma = tipoTurma;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
