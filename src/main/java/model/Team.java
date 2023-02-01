package model;

import javax.persistence.*;
import java.util.Date;

public class Team {

    @Column
    private String codigo;
    @Column
    private String nome;
    @Column
    private Date dataInicio;
    @Column
    private Date dataFim;
    @Column
    private String turno;
    @Column
    private String tipoTurma;

    public Team(String codigo, String nome, Date dataInicio, Date dataFim, String turno, String tipoTurma) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.turno = turno;
        this.tipoTurma = tipoTurma;
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

    public String getTipoTurma() {
        return tipoTurma;
    }

    public void setTipoTurma(String tipoTurma) {
        this.tipoTurma = tipoTurma;
    }

}
