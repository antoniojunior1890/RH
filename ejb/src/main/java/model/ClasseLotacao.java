package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Renan on 06/07/16.
 */

@Entity
@Table(name = "RH34_CLASSE_LOTACAO")
@SequenceGenerator(name = "RH34_SQC", sequenceName = "RH34_SQC", allocationSize = 1, initialValue = 1)
public class ClasseLotacao implements Serializable, AbstractEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RH34_SQC")
    @Column(name = "RH34_COD_LOTACAO")
    private Long id;

    @Column(name = "RH34_DESCRICAO")
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
        return "ClasseLotacao{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClasseLotacao that = (ClasseLotacao) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
