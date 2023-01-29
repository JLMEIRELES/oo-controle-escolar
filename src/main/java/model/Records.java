package model;

import javax.persistence.*;

@Entity
@Table(name = "records")
public class Records {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String componentesCurriculares;
    @Column
    private String codigo;
    @Column
    private String matricula;
    @Column
    private String filiacao;

    @OneToOne(optional = false)
    @JoinColumn(name = "student_id")
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComponentesCurriculares() {
        return componentesCurriculares;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getFiliacao() {
        return filiacao;
    }

    public void setComponentesCurriculares(String componentesCurriculares) {
        this.componentesCurriculares = componentesCurriculares;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setFiliacao(String filiacao) {
        this.filiacao = filiacao;
    }
}
