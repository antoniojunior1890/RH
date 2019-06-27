package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "RH02_SERVIDOR")
@SequenceGenerator(name = "RH02_SQC", sequenceName = "RH02_SQC", allocationSize = 1, initialValue = 1)
public class Servidor implements Serializable, AbstractEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RH02_SQC")
    @Column(name = "RH02_COD_SERVIDOR")
    private Long id;

    @Column(name = "RH02_MATRICULA")
    private String matricula;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RH02_DATA_ADMISSAO")
    private Date dataAdmissao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RH02_DATA_DEMISSAO")
    private Date dataDemissao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RH02_DATA_ANUENIO_FUNCAO")
    private Date dataAnuenioFuncao;

    @Column(name = "RH02_QTD_DEPENDENTE")
    private Integer quantidadeDependentes;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RH02_DATA_CADASTRO")
    private Date dataCadastro;

    @Column(name = "RH02_CATEGORIA_FUNCAO")
    private String categoriaFuncao;

    @OneToOne
    @JoinColumn(name = "FKRH02RH05_COD_TIPO_VINCULO")
    private TipoVinculo tipoVinculo;

    @OneToOne
    @JoinColumn(name = "FKRH02RH07_COD_SITUACAO")
    private Situacao situacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FKRH02RH01_COD_PESSOA")
    private Pessoa pessoa;

    @OneToOne
    @JoinColumn(name = "FKRH02RH16_COD_CARGO")
    private Cargo cargo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "FKRH21RH02_COD_SERVIDOR")
    private Set<Dependente> dependentes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "FKRH37RH02_COD_SERVIDOR")
    private Set<TipoContrato> tipoContratos;

    @OneToMany(mappedBy = "servidor")
    private Collection<ServidorLotacao> servidorLotacoes;

    @OneToMany
    @JoinColumn(name = "FKRH36RH02_COD_SERVIDOR")
    private Collection<LotacaoReal> lotacoes;

    @OneToMany
    @JoinColumn(name = "FKRH19RH02_COD_SERVIDOR")
    private Set<EscalaServidor> escalas;

    @OneToMany
    @JoinColumn(name = "FKRH37RH02_COD_SERVIDOR")
    private Collection<Contrato> contratos;

    @Transient
    private EscalaServidor escalaAtiva;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Date getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(Date dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public Date getDataAnuenioFuncao() {
        return dataAnuenioFuncao;
    }

    public void setDataAnuenioFuncao(Date dataAnuenioFuncao) {
        this.dataAnuenioFuncao = dataAnuenioFuncao;
    }

    public Integer getQuantidadeDependentes() {
        return quantidadeDependentes;
    }

    public void setQuantidadeDependentes(Integer quantidadeDependentes) {
        this.quantidadeDependentes = quantidadeDependentes;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getCategoriaFuncao() {
        return categoriaFuncao;
    }

    public void setCategoriaFuncao(String categoriaFuncao) {
        this.categoriaFuncao = categoriaFuncao;
    }

    public TipoVinculo getTipoVinculo() {
        return tipoVinculo;
    }

    public void setTipoVinculo(TipoVinculo tipoVinculo) {
        this.tipoVinculo = tipoVinculo;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Set<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(Set<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

    public Collection<ServidorLotacao> getServidorLotacoes() {
        return servidorLotacoes;
    }

    public void setServidorLotacoes(Collection<ServidorLotacao> servidorLotacoes) {
        this.servidorLotacoes = servidorLotacoes;
    }

    public Collection<LotacaoReal> getLotacoes() {
        return lotacoes;
    }

    public void setLotacoes(Collection<LotacaoReal> lotacoes) {
        this.lotacoes = lotacoes;
    }

    public Set<EscalaServidor> getEscalas() {
        return escalas;
    }

    public void setEscalas(Set<EscalaServidor> escalas) {
        this.escalas = escalas;
    }

    public EscalaServidor getEscalaAtiva() {
        for (EscalaServidor escalaServidor : escalas) {
            if(escalaServidor.getAtiva() == 1){
                escalaAtiva = escalaServidor;
                break;
            }
        }
        return ((escalaAtiva == null) ? new EscalaServidor() : escalaAtiva);
    }

    public void setEscalaAtiva(EscalaServidor escalaAtiva) {
        this.escalaAtiva = escalaAtiva;
    }

    public Set<TipoContrato> getTipoContratos() {
        return tipoContratos;
    }

    public void setTipoContratos(Set<TipoContrato> tipoContratos) {
        this.tipoContratos = tipoContratos;
    }

    public Collection<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(Collection<Contrato> contratos) {
        this.contratos = contratos;
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
        Servidor other = (Servidor) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Servidor{" +
                "id=" + id +
                ", matricula=" + matricula +
                ", dataAdmissao=" + dataAdmissao +
                ", dataDemissao=" + dataDemissao +
                ", dataAnuenioFuncao=" + dataAnuenioFuncao +
                ", quantidadeDependentes=" + quantidadeDependentes +
                ", dataCadastro=" + dataCadastro +
                ", categoriaFuncao='" + categoriaFuncao + '\'' +
                ", tipoVinculo=" + tipoVinculo +
                ", situacao=" + situacao +
                ", pessoa=" + pessoa +
                ", cargo=" + cargo +
                ", dependentes=" + dependentes +
                ", tipoContratos=" + tipoContratos +
                ", servidorLotacoes=" + servidorLotacoes +
                ", lotacoes=" + lotacoes +
                ", escalas=" + escalas +
                ", escalaAtiva=" + escalaAtiva +
                '}';
    }
}
