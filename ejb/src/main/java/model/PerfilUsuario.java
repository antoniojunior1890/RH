package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Renan on 25/07/16.
 */
@Entity
@Table(name = "CG17_PERFIL_USUARIO")
@SequenceGenerator(name = "CG17_SQC", sequenceName = "CG17_SQC", allocationSize = 1, initialValue = 1)
public class PerfilUsuario implements Serializable, AbstractEntity {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CG17_SQC")
    @Column(name = "CG17_COD_PERFIL_USUARIO")
    private Long id;

    @Column(name = "CG17_DATA_HABILITACAO")
    private Date dataHabilitacao;

    @Column(name = "CG17_DATA_DESABILITACAO")
    private Date dataDesabilitacao;

    @OneToOne
    @JoinColumn(name = "FKCG17CG14_COD_PERFIL")
    private Perfil perfil;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataHabilitacao() {
        return dataHabilitacao;
    }

    public void setDataHabilitacao(Date dataHabilitacao) {
        this.dataHabilitacao = dataHabilitacao;
    }

    public Date getDataDesabilitacao() {
        return dataDesabilitacao;
    }

    public void setDataDesabilitacao(Date dataDesabilitacao) {
        this.dataDesabilitacao = dataDesabilitacao;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PerfilUsuario that = (PerfilUsuario) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PerfilUsuario{" +
                "id=" + id +
                ", dataHabilitacao=" + dataHabilitacao +
                ", dataDesabilitacao=" + dataDesabilitacao +
                ", perfil=" + perfil +
                '}';
    }
}
