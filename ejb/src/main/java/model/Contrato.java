package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Renan on 19/07/16.
 */

@Entity
@Table(name = "RH37_CONTRATO")
@SequenceGenerator(name = "RH37_SQC", sequenceName = "RH37_SQC", allocationSize = 1, initialValue = 1)
public class Contrato implements Serializable, AbstractEntity {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RH37_SQC")
    @Column(name = "RH37_COD_CONTRATO")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "RH37_DATA_INICIO")
    private Date dataInicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "RH37_DATA_FIM")
    private Date dataFim;

    @Column(name = "RH37_VIGENCIA")
    private Integer vigencia;

    @OneToOne
    @JoinColumn(name = "FKRH37RH38_COD_TIPO_CONTRATO")
    private TipoContrato tipoContrato;

    @ManyToOne
    @JoinColumn(name = "FKRH37RH02_COD_SERVIDOR")
    private Servidor servidor;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "id=" + id +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", vigencia=" + vigencia +
                ", tipoContrato=" + tipoContrato +
                ", servidor=" + servidor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contrato contrato = (Contrato) o;

        return id != null ? id.equals(contrato.id) : contrato.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
