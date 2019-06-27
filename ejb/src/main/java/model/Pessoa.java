package model;


import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.validation.Valid;

/**
 * @author Antonio
 *
 */
@Entity
@Table(name = "RH01_PESSOA")
@SequenceGenerator(name = "RH01_SQC", sequenceName = "RH01_SQC", allocationSize = 1, initialValue = 1)
public class Pessoa implements Serializable, AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RH01_SQC")
	@Column(name = "RH01_COD_PESSOA")
	private Long id;

	@Column(name = "RH01_NOME")
	private String nome;

	@Column(name = "RH01_MAE")
	private String mae;

	@Column(name = "RH01_PAI")
	private String pai;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RH01_DATA_NASCIMENTO")
	private Date dataNascimento;

	@Column(name = "RH01_LOGRADOURO")
	private String logradouro;

	@Column(name = "RH01_NUMERO")
	private String numero;

	@Column(name = "RH01_COMPLEMENTO")
	private String complemento;

	@Column(name = "RH01_BAIRRO")
	private String bairro;

	@Column(name = "RH01_CEP")
	private String cep;

	@Column(name = "RH01_TELEFONE")
	private String telefone;

	@Column(name = "RH01_CELULAR")
	private String celular;

	@Column(name = "RH01_EMAIL")
	private String email;

	@Column(name = "RH01_CPF")
	private String cpf;

	@Column(name = "RH01_RG")
	private String rg;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RH01_DATA_RG")
	private Date dataRg;

	@Column(name = "RH01_TITULO")
	private String titulo;

	@Column(name = "RH01_SECAO_TITULO")
	private String secaoTitulo;

	@Column(name = "RH01_ZONA_TITULO")
	private String zonaTitulo;

	@Column(name = "RH01_CERTIFICADO_RESERVISTA")
	private String certificacaoReservista;

	@Column(name="RH01_PIS_PASEP")
	private String pis;

	@OneToMany
	@JoinColumn(name = "FKRH12RH01_COD_PESSOA")
	private Collection<Formacao> formacoes;

	@OneToOne
	@JoinColumn(name = "FKRH01CG03_COD_SEXO")
	private Sexo sexo;

	@OneToOne
	@JoinColumn(name = "FKRH01CG01_COD_MUNICIPIO_END")
	private Municipio municipioEndereco;

	@OneToOne
	@JoinColumn(name = "FKRH01CG02_COD_UF_ENDERECO")
	private Uf ufEndereco;

	@OneToOne
	@JoinColumn(name = "FKRH01CG04_COD_ORGAO_EXPEDIDOR")
	private OrgaoExpedidor orgaoExpedidor;

	@OneToOne
	@JoinColumn(name = "FKRH01CG02_COD_UF_RG")
	private Uf ufRg;

	@OneToOne
	@JoinColumn(name = "FKRH01CG01_COD_MUNICIPIO_NAT")
	private Municipio municipioNascimento;

    @OneToOne
    @JoinColumn(name = "FKRH01CG02_COD_UF_NASCIMENTO")
    private Uf ufNascimento;

    @OneToOne
	@JoinColumn(name = "FKRH01CG05_COD_PAIS_NAC")
	private Pais paisNacionalidade;

    @OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<DadosBancarios> dadosBancarios;

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

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataRg() {
		return dataRg;
	}

	public void setDataRg(Date dataRg) {
		this.dataRg = dataRg;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSecaoTitulo() {
		return secaoTitulo;
	}

	public void setSecaoTitulo(String secaoTitulo) {
		this.secaoTitulo = secaoTitulo;
	}

	public String getZonaTitulo() {
		return zonaTitulo;
	}

	public void setZonaTitulo(String zonaTitulo) {
		this.zonaTitulo = zonaTitulo;
	}

	public String getCertificacaoReservista() {
		return certificacaoReservista;
	}

	public void setCertificacaoReservista(String certificacaoReservista) {this.certificacaoReservista = certificacaoReservista;	}

	public Collection<Formacao> getFormacoes() {
		return formacoes;
	}

	public void setFormacoes(Collection<Formacao> formacoes) {
		this.formacoes = formacoes;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Municipio getMunicipioEndereco() {
		return municipioEndereco;
	}

	public void setMunicipioEndereco(Municipio municipioEndereco) {
		this.municipioEndereco = municipioEndereco;
	}

	public OrgaoExpedidor getOrgaoExpedidor() {
		return orgaoExpedidor;
	}

	public void setOrgaoExpedidor(OrgaoExpedidor orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}

	public Uf getUfRg() {
		return ufRg;
	}

	public void setUfRg(Uf ufRg) {
		this.ufRg = ufRg;
	}

	public Municipio getMunicipioNascimento() {
		return municipioNascimento;
	}

	public void setMunicipioNascimento(Municipio municipioNascimento) {
		this.municipioNascimento = municipioNascimento;
	}

	public Pais getPaisNacionalidade() {
		return paisNacionalidade;
	}

	public void setPaisNacionalidade(Pais paisNacionalidade) {
		this.paisNacionalidade = paisNacionalidade;
	}

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Uf getUfNascimento() {
        return ufNascimento;
    }

    public void setUfNascimento(Uf ufNascimento) {
        this.ufNascimento = ufNascimento;
    }

    public Uf getUfEndereco() {
        return ufEndereco;
    }

    public void setUfEndereco(Uf ufEndereco) {
        this.ufEndereco = ufEndereco;
    }

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

    public Set<DadosBancarios> getDadosBancarios() {
        return dadosBancarios;
    }

    public void setDadosBancarios(Set<DadosBancarios> dadosBancarios) {
        this.dadosBancarios = dadosBancarios;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", mae='" + mae + '\'' +
                ", pai='" + pai + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", telefone='" + telefone + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", dataRg=" + dataRg +
                ", titulo='" + titulo + '\'' +
                ", secaoTitulo='" + secaoTitulo + '\'' +
                ", zonaTitulo='" + zonaTitulo + '\'' +
                ", certificacaoReservista='" + certificacaoReservista + '\'' +
                ", pis='" + pis + '\'' +
                ", formacoes=" + formacoes +
                ", sexo=" + sexo +
                ", municipioEndereco=" + municipioEndereco +
                ", ufEndereco=" + ufEndereco +
                ", orgaoExpedidor=" + orgaoExpedidor +
                ", ufRg=" + ufRg +
                ", municipioNascimento=" + municipioNascimento +
                ", ufNascimento=" + ufNascimento +
                ", paisNacionalidade=" + paisNacionalidade +
                ", dadosBancarios=" + dadosBancarios +
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

}
