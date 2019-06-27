package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Renan on 12/07/16.
 */
@Entity
@Table(name = "RH19_ESCALA_SERVIDOR")
@SequenceGenerator(name = "RH19_SQC", sequenceName = "RH19_SQC", allocationSize = 1, initialValue = 1)
public class EscalaServidor implements Serializable, AbstractEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RH19_SQC")
    @Column(name = "RH19_COD_ESCALA_SERVIDOR")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RH19_DATA_CADASTRO")
    private Date dataCadastro;

    @Column(name = "RH19_ATIVA")
    private Integer ativa;

    @OneToOne
    @JoinColumn(name = "FKRH19RH15_COD_ESCALA_TRABALHO")
    private EscalaTrabalho escalaTrabalho;

    @ManyToOne
    @JoinColumn(name = "FKRH19RH02_COD_SERVIDOR")
    private Servidor servidor;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Integer getAtiva() {
        return ativa;
    }

    public void setAtiva(Integer ativa) {
        this.ativa = ativa;
    }

    public EscalaTrabalho getEscalaTrabalho() {
        return escalaTrabalho;
    }

    public void setEscalaTrabalho(EscalaTrabalho escalaTrabalho) {
        this.escalaTrabalho = escalaTrabalho;
    }

    @Override
    public String toString() {
        return "EscalaServidor{" +
                "id=" + id +
                ", dataCadastro=" + dataCadastro +
                ", ativa=" + ativa +
                ", escalaTrabalho=" + escalaTrabalho +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EscalaServidor that = (EscalaServidor) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
