package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Renan on 13/07/16.
 */
@Entity
@Table(name = "RH35_SIMBOLOGIA")
@SequenceGenerator(name = "RH35_SQC", sequenceName = "RH35_SQC", allocationSize = 1, initialValue = 1)
public class Simbologia implements Serializable, AbstractEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RH35_SQC")
    @Column(name = "RH35_COD_SIMBOLOGIA")
    private Long id;


    @Column(name = "RH35_DESCRICAO")
    private String descricao;

    @Column(name = "RH35_SIGLA")
    private String sigla;

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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Simbologia that = (Simbologia) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Simbologia{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", sigla='" + sigla + '\'' +
                '}';
    }
}
