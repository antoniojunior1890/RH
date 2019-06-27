package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RH16_CARGO")
@SequenceGenerator(name = "RH16_SQC", sequenceName = "RH16_SQC", allocationSize = 1, initialValue = 1)
public class Cargo implements Serializable, AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RH16_SQC")
	@Column(name = "RH16_COD_CARGO")
	private Long id;

	@Column(name = "RH16_DESCRICAO")
	private String descricao;

	@Column(name = "RH16_COMISSIONADO")
	private Integer comissionado;

	@Column(name = "RH16_COD_FOLHA")
	private String codigoFolha;

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

	public Integer getComissionado() {
		return comissionado;
	}

	public void setComissionado(Integer comissionado) {
		this.comissionado = comissionado;
	}

    public String getCodigoFolha() {
        return codigoFolha;
    }

    public void setCodigoFolha(String codigoFolha) {
        this.codigoFolha = codigoFolha;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", comissionado=" + comissionado +
                ", codigoFolha='" + codigoFolha + '\'' +
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
		Cargo other = (Cargo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
