package model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "CG05_PAIS")
@SequenceGenerator(name = "CG05_SQC", sequenceName = "CG05_SQC", allocationSize = 1, initialValue = 1)
public class Pais implements Serializable, AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CG05_SQC")
	@Column(name = "CG05_COD_PAIS")
	private Long id;

	@Column(name = "CG05_NOME")
	private String nome;

	@Column(name = "CG05_SIGLA")
	private String sigla;

	@OneToMany
	@JoinColumn(name = "FKCG02CG05_COD_PAIS")
	private List<Uf> estados;

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
		Pais other = (Pais) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", estados=" + estados +
                '}';
    }
}
