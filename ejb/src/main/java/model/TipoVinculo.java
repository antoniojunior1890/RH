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
@Table(name = "RH05_TIPO_VINCULO")
@SequenceGenerator(name = "RH05_SQC", sequenceName = "RH05_SQC", allocationSize = 1, initialValue = 1)
public class TipoVinculo implements Serializable, AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Long ID_EFETIVO = 1L;
	public static final Long ID_CONTRATADO = 2L;
	public static final Long ID_DISPOSICAO = 3L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RH05_SQC")
	@Column(name = "RH05_COD_TIPO_VINCULO")
	private Long id;

	@Column(name = "RH05_DESCRICAO")
	private String descricao;

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
		return "Vinculo [id=" + id + ", descricao=" + descricao + "]";
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
		TipoVinculo other = (TipoVinculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
