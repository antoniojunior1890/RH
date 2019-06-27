package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "RH21_DEPENDENTE")
@SequenceGenerator(name = "RH21_SQC", sequenceName = "RH21_SQC", allocationSize = 1, initialValue = 1)
public class Dependente implements Serializable, AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RH21_SQC")
	@Column(name = "RH21_COD_DEPENDENTE")
	private Long id;

	@Column(name = "RH21_NOME")
	private String nome;

	@Column(name = "RH21_CPF")
	private String cpf;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RH21_NASCIMENTO")
	private Date nascimento;

	@OneToOne
	@JoinColumn(name = "FKRH21RH22_COD_PARENTESCO")
	private Parentesco parentesco;
	
	@ManyToOne
	@JoinColumn(name = "FKRH21RH02_COD_SERVIDOR")
	private Servidor servidor;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Parentesco getParentesco() {
		return parentesco;
	}

	public void setParentesco(Parentesco parentesco) {
		this.parentesco = parentesco;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	@Override
	public String toString() {
		return "Dependente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", nascimento=" + nascimento
				+ ", parentesco=" + parentesco + ", servidor=" + servidor + "]";
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
		Dependente other = (Dependente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
