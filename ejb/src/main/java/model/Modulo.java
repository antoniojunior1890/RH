package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Renan on 25/07/16.
 */
@Entity
@Table(name = "CG13_MODULO")
@SequenceGenerator(name = "CG13_SQC", sequenceName = "CG13_SQC", allocationSize = 1, initialValue = 1)
public class Modulo implements Serializable, AbstractEntity {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CG13_SQC")
    @Column(name = "CG13_COD_MODULO")
    private Long id;

    @Column(name = "CG13_DESCRICAO")
    private String descricao;

    @OneToOne
    @JoinColumn(name = "FKCG13CG06_COD_APLICACAO")
    private Aplicacao aplicacao;

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

    public Aplicacao getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Modulo modulo = (Modulo) o;

        return id != null ? id.equals(modulo.id) : modulo.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Modulo{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", aplicacao=" + aplicacao +
                '}';
    }
}
