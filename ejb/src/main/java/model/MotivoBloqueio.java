package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Renan on 21/07/16.
 */
@Entity
@Table(name = "CG18_MOTIVO_BLOQUEIO")
@SequenceGenerator(name = "CG18_SQC", sequenceName = "CG18_SQC", allocationSize = 1, initialValue = 1)
public class MotivoBloqueio implements Serializable, AbstractEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CG18_SQC")
    @Column(name = "CG18_COD_MOTIVO_BLOQUEIO")
    private Long id;

    @Column(name = "CG16_DESCRICAO")
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MotivoBloqueio that = (MotivoBloqueio) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MotivoBloqueio{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
