package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by antonio on 19/07/16.
 */
@Entity
@Table(name = "CG21_TIPO_POSSE")
@SequenceGenerator(name = "CG21_SQC", sequenceName = "CG21_SQC", allocationSize = 1, initialValue = 1)
public class TipoPosse implements Serializable, AbstractEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CG21_SQC")
    @Column(name = "CG21_COD_TIPO_POSSE")
    private Long id;

    @Column(name = "CG21_DESCRICAO")
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
        return "TipoPosse{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoPosse tipoPosse = (TipoPosse) o;

        if (id != null ? !id.equals(tipoPosse.id) : tipoPosse.id != null) return false;
        return descricao != null ? descricao.equals(tipoPosse.descricao) : tipoPosse.descricao == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
    }
}
