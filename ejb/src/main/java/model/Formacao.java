package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RH12_FORMACAO")
@SequenceGenerator(name = "RH12_SQC", sequenceName = "RH12_SQC", allocationSize = 1, initialValue = 1)
public class Formacao implements Serializable, AbstractEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RH12_SQC")
	@Column(name = "RH12_COD_FORMACAO")
	private Long id;

	@Column(name = "RH12_IE")
	private String instituicaoEnsino;

	@Column(name = "RH12_CURSO")
	private String curso;

	@Column(name = "RH12_CARGA_HORARIA")
	private String cargaHorariaCurso;

	@Column(name = "RH12_ANO_CONCLUSAO")
	private String anoConclusao;

	@OneToOne
	@JoinColumn(name = "FKRH12RH08_COD_AREA")
	private Area area;

	@OneToOne
	@JoinColumn(name = "FKRH12RH10_COD_NIVEL_FORMACAO")
	private NivelFormacao nivelFormacao;

	@OneToOne
	@JoinColumn(name = "FKRH12RH11_COD_STATUS_FORMACAO")
	private StatusFormacao statusFormacao;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "FKRH13RH12_COD_FORMACAO")
	private Collection<Documento> documentos;

	@ManyToOne
	@JoinColumn(name = "FKRH12RH01_COD_PESSOA")
	private Pessoa pessoa;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInstituicaoEnsino() {
		return instituicaoEnsino;
	}

	public void setInstituicaoEnsino(String instituicaoEnsino) {
		this.instituicaoEnsino = instituicaoEnsino;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getCargaHorariaCurso() {
		return cargaHorariaCurso;
	}

	public void setCargaHorariaCurso(String cargaHorariaCurso) {
		this.cargaHorariaCurso = cargaHorariaCurso;
	}

	public String getAnoConclusao() {
		return anoConclusao;
	}

	public void setAnoConclusao(String anoConclusao) {
		this.anoConclusao = anoConclusao;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public NivelFormacao getNivelFormacao() {
		return nivelFormacao;
	}

	public void setNivelFormacao(NivelFormacao nivelFormacao) {
		this.nivelFormacao = nivelFormacao;
	}

	public StatusFormacao getStatusFormacao() {
		return statusFormacao;
	}

	public void setStatusFormacao(StatusFormacao statusFormacao) {
		this.statusFormacao = statusFormacao;
	}

	public Collection<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(Collection<Documento> documentos) {
		this.documentos = documentos;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Formacao{" +
				"id=" + id +
				", instituicaoEnsino='" + instituicaoEnsino + '\'' +
				", curso='" + curso + '\'' +
				", cargaHorariaCurso='" + cargaHorariaCurso + '\'' +
				", anoConclusao='" + anoConclusao + '\'' +
				", area=" + area +
				", nivelFormacao=" + nivelFormacao +
				", statusFormacao=" + statusFormacao +
				", documentos=" + documentos +
				", pessoa=" + pessoa +
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
		Formacao other = (Formacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
