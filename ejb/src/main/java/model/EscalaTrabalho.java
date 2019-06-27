package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Renan on 12/07/16.
 */
@Entity
@Table(name = "RH15_ESCALA_TRABALHO")
@SequenceGenerator(name = "RH15_SQC", sequenceName = "RH15_SQC", allocationSize = 1, initialValue = 1)
public class EscalaTrabalho implements Serializable, AbstractEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RH15_SQC")
    @Column(name = "RH15_COD_ESCALA_TRABALHO")
    private Long id;

    @Column(name = "RH15_DESCRICAO")
    private String descricao;

    @Temporal(TemporalType.TIME)
    @Column(name = "RH15_HORA_INICIO")
    private Date horaInicio;

    @Column(name = "RH15_CARGA_DIARIA")
    private Integer cargaDiaria;

    @Column(name = "RH15_INTRAJORNADA")
    private Integer intraJornada;

    @Column(name = "RH15_EXTRAJORNADA")
    private Integer extraJornada;

    @Column(name = "RH15_FIM_SEMANA")
    private Integer fimSemana;

    @Column(name = "RH15_FERIADO")
    private Integer feriado;

    @Column(name = "RH15_PLANTAO")
    private Integer plantao;

    @Column(name = "RH15_SEMANAL")
    private Integer semanal;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Integer getCargaDiaria() {
        return cargaDiaria;
    }

    public void setCargaDiaria(Integer cargaDiaria) {
        this.cargaDiaria = cargaDiaria;
    }

    public Integer getIntraJornada() {
        return intraJornada;
    }

    public void setIntraJornada(Integer intraJornada) {
        this.intraJornada = intraJornada;
    }

    public Integer getExtraJornada() {
        return extraJornada;
    }

    public void setExtraJornada(Integer extraJornada) {
        this.extraJornada = extraJornada;
    }

    public Integer getFimSemana() {
        return fimSemana;
    }

    public void setFimSemana(Integer fimSemana) {
        this.fimSemana = fimSemana;
    }

    public Integer getFeriado() {
        return feriado;
    }

    public void setFeriado(Integer feriado) {
        this.feriado = feriado;
    }

    public Integer getPlantao() {
        return plantao;
    }

    public void setPlantao(Integer plantao) {
        this.plantao = plantao;
    }

    public Integer getSemanal() {
        return semanal;
    }

    public void setSemanal(Integer semanal) {
        this.semanal = semanal;
    }

    @Override
    public String toString() {
        return "EscalaTrabalho{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", horaInicio=" + horaInicio +
                ", cargaDiaria=" + cargaDiaria +
                ", intraJornada=" + intraJornada +
                ", extraJornada=" + extraJornada +
                ", fimSemana=" + fimSemana +
                ", feriado=" + feriado +
                ", plantao=" + plantao +
                ", semanal=" + semanal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EscalaTrabalho that = (EscalaTrabalho) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
