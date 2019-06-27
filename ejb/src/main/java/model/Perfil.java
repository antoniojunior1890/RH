package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Renan on 25/07/16.
 */
@Entity
@Table(name = "CG14_PERFIL")
@SequenceGenerator(name = "CG14_SQC", sequenceName = "CG14_SQC", allocationSize = 1, initialValue = 1)
public class Perfil implements Serializable, AbstractEntity {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CG14_SQC")
    @Column(name = "CG14_COD_PERFIL")
    private Long id;

    @Column(name = "CG14_NOME")
    private String nome;

    @Column(name = "CG14_DESCRICAO")
    private String descricao;

    @OneToMany
    @JoinColumn(name = "FKCG15CG14_COD_PERFIL")
    private Collection<DetalhePerfil> detalhesPerfil;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Collection<DetalhePerfil> getDetalhesPerfil() {
        return detalhesPerfil;
    }

    public void setDetalhesPerfil(Collection<DetalhePerfil> detalhesPerfil) {
        this.detalhesPerfil = detalhesPerfil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Perfil perfil = (Perfil) o;

        return id != null ? id.equals(perfil.id) : perfil.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", detalhesPerfil=" + detalhesPerfil +
                '}';
    }
}
