package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Renan on 25/07/16.
 */
@Entity
@Table(name = "CG15_DETALHE_PERFIL")
@SequenceGenerator(name = "CG15_SQC", sequenceName = "CG15_SQC", allocationSize = 1, initialValue = 1)
public class DetalhePerfil implements Serializable, AbstractEntity {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CG15_SQC")
    @Column(name = "CG15_COD_DETALHE_PERFIL")
    private Long id;

    @Column(name = "CG15_SOMENTE_LEITURA")
    private Integer somenteLeitura;

    @OneToOne
    @JoinColumn(name = "FKCG15CG13_COD_MODULO")
    private Modulo modulo;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSomenteLeitura() {
        return somenteLeitura;
    }

    public void setSomenteLeitura(Integer somenteLeitura) {
        this.somenteLeitura = somenteLeitura;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetalhePerfil that = (DetalhePerfil) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "DetalhePerfil{" +
                "id=" + id +
                ", somenteLeitura=" + somenteLeitura +
                ", modulo=" + modulo +
                '}';
    }
}
