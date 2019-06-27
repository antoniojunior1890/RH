package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Renan on 06/07/16.
 */
@Entity
@Table(name = "CG27_BANCO")
@SequenceGenerator(name = "CG27_SQC", sequenceName = "CG27_SQC", allocationSize = 1, initialValue = 1)
public class Banco implements Serializable, AbstractEntity {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CG27_SQC")
    @Column(name = "CG27_COD_BANCO")
    private Long id;

    @Column(name = "CG27_COD_FEBRABAN")
    private Integer codigoFebraban;

    @Column(name = "CG27_DESCRICAO")
    private String descricao;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigoFebraban() {
        return codigoFebraban;
    }

    public void setCodigoFebraban(Integer codigoFebraban) {
        this.codigoFebraban = codigoFebraban;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "id=" + id +
                ", codigoFebraban=" + codigoFebraban +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Banco banco = (Banco) o;

        return id != null ? id.equals(banco.id) : banco.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
