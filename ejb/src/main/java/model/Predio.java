package model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CG20_PREDIO")
@SequenceGenerator(name = "CG20_SQC", sequenceName = "CG20_SQC", allocationSize = 1, initialValue = 1)
public class Predio implements Serializable, AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CG20_SQC")
	@Column(name = "CG20_COD_PREDIO")
	private Long id;

	@Column(name = "CG20_DESCRICAO")
	private String descricao;

	@Column(name = "CG20_LOGRADOURO")
	private String logradouro;

	@Column(name = "CG20_NUMERO")
	private String numero;

	@Column(name = "CG20_COMPLEMENTO")
	private String complemento;

	@Column(name = "CG20_BAIRRO")
	private String bairro;

	@Column(name = "CG20_CEP")
	private String cep;

	@OneToOne
	@JoinColumn(name = "FKCG20CG01_COD_MUNICIPIO")
	private Municipio municipio;

    @OneToOne
    @JoinColumn(name = "FKCG20CG21_COD_TIPO_POSSE")
    private TipoPosse tipoPosse;

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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

    public TipoPosse getTipoPosse() {
        return tipoPosse;
    }

    public void setTipoPosse(TipoPosse tipoPosse) {
        this.tipoPosse = tipoPosse;
    }

    @Override
    public String toString() {
        return "Predio{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", municipio=" + municipio +
                ", tipoPosse=" + tipoPosse +
                '}';
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Predio other = (Predio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
