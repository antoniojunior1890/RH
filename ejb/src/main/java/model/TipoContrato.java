package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Renan on 19/07/16.
 */

@Entity
@Table(name = "RH38_TIPO_CONTRATO")
@SequenceGenerator(name = "RH38_SQC", sequenceName = "RH38_SQC", allocationSize = 1, initialValue = 1)
public class TipoContrato implements Serializable, AbstractEntity {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RH38_SQC")
    @Column(name = "RH38_COD_TIPO_CONTRATO")
    private Long id;

    @Column(name = "RH38_DESCRICAO")
    private String descricao;

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

    @Override
    public String toString() {
        return "TipoContrato{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoContrato that = (TipoContrato) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
