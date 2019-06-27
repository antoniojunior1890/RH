package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "RH03_LOTACAO_FOLHA")
@SequenceGenerator(name = "RH03_SQC", sequenceName = "RH03_SQC", allocationSize = 1, initialValue = 1)
public class LotacaoFolha implements Serializable, AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RH03_SQC")
	@Column(name = "RH03_COD_LOTACAO_FOLHA")
	private Long id;

	@Column(name = "RH03_NOME")
	private String nome;

	@Column(name = "RH03_COD_FOLHA")
	private String codigoFolha;

    @OneToOne
    @JoinColumn(name = "FKRH03RH04_COD_ORGAO")
    private Orgao orgao;

    @ManyToOne
    @JoinColumn(name = "FKRH03RH36_COD_LOTACAO_REAL")
    private LotacaoReal lotacaoReal;

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

    public String getCodigoFolha() {
        return codigoFolha;
    }

    public void setCodigoFolha(String codigoFolha) {
        this.codigoFolha = codigoFolha;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }

    public LotacaoReal getLotacaoReal() {
        return lotacaoReal;
    }

    public void setLotacaoReal(LotacaoReal lotacaoReal) {
        this.lotacaoReal = lotacaoReal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LotacaoFolha lotacaoFolha = (LotacaoFolha) o;

        return id != null ? id.equals(lotacaoFolha.id) : lotacaoFolha.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "LotacaoFolha{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", codigoFolha='" + codigoFolha + '\'' +
                ", orgao=" + orgao +
                '}';
    }
}
