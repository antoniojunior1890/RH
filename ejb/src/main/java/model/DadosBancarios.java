package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Renan on 06/07/16.
 */
@Entity
@Table(name = "RH33_DADOS_BANCARIOS")
@SequenceGenerator(name = "RH33_SQC", sequenceName = "RH33_SQC", allocationSize = 1, initialValue = 1)
public class DadosBancarios implements Serializable, AbstractEntity {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RH33_SQC")
    @Column(name = "RH33_COD_DADOS_BANCARIOS")
    private Long id;

    @Column(name = "RH33_AGENCIA")
    private String agencia;

    @Column(name = "RH33_CONTA")
    private String conta;

    @Column(name = "RH33_ATIVO")
    private Integer ativo;

    @OneToOne
    @JoinColumn(name = "FKRH33CG27_COD_BANCO")
    private Banco banco;

    @ManyToOne
    @JoinColumn(name = "FKRH33RH01_COD_PESSOA")
    private Pessoa pessoa;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "DadosBancarios{" +
                "id=" + id +
                ", agencia='" + agencia + '\'' +
                ", conta='" + conta + '\'' +
                ", ativo=" + ativo +
                ", banco=" + banco +
                ", pessoa=" + pessoa +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DadosBancarios that = (DadosBancarios) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
