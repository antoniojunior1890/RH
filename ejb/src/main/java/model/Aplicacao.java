package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Renan on 25/07/16.
 */
@Entity
@Table(name = "CG06_APLICACAO")
@SequenceGenerator(name = "CG06_SQC", sequenceName = "CG06_SQC", allocationSize = 1, initialValue = 1)
public class Aplicacao implements Serializable, AbstractEntity {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CG06_SQC")
    @Column(name = "CG06_COD_APLICACAO")
    private Long id;

    @Column(name = "CG06_NOME")
    private String nome;

    @Column(name = "CG06_DESCRICAO")
    private String descricao;

    @Column(name = "CG06_URL")
    private String url;

    @Column(name = "CG06_ICONE")
    private String icone;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aplicacao aplicacao = (Aplicacao) o;

        return id != null ? id.equals(aplicacao.id) : aplicacao.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Aplicacao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", url='" + url + '\'' +
                ", icone='" + icone + '\'' +
                '}';
    }
}
