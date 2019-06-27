package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Renan on 12/07/16.
 */
@Entity
@Table(name = "RH32_TIPO_LOTACAO")
@SequenceGenerator(name = "RH32_SQC", sequenceName = "RH32_SQC", allocationSize = 1, initialValue = 1)
public class TipoLotacao implements Serializable, AbstractEntity {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RH32_SQC")
    @Column(name = "RH32_COD_TIPO_LOTACAO")
    private Long id;

    @Column(name = "RH32_DESCRICAO")
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
        return "TipoLotacao{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoLotacao that = (TipoLotacao) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
