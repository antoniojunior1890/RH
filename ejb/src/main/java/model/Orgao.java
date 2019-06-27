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
@Table(name = "RH04_ORGAO")
@SequenceGenerator(name = "RH04_SQC", sequenceName = "RH04_SQC", allocationSize = 1, initialValue = 1)
public class Orgao implements Serializable, AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RH04_SQC")
	@Column(name = "RH04_COD_ORGAO")
	private Long id;

	@Column(name = "RH04_DESCRICAO")
	private String descricao;

	@Column(name = "RH04_COD_FOLHA")
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

	public void setDescricao(String decricao) {
		this.descricao = decricao;
	}

    public String getCodigoFolha() {
        return codigoFolha;
    }

    public void setCodigoFolha(String codigoFolha) {
        this.codigoFolha = codigoFolha;
    }

    @Override
    public String toString() {
        return "Orgao{" +
                "id=" + id +
                ", decricao='" + descricao + '\'' +
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
		Orgao other = (Orgao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
