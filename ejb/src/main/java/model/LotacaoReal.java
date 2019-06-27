package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Renan on 14/07/16.
 */
@Entity
@Table(name = "RH36_LOTACAO_REAL")
@SequenceGenerator(name = "RH36_SQC", sequenceName = "RH36_SQC", allocationSize = 1, initialValue = 1)
public class LotacaoReal implements Serializable, AbstractEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RH36_SQC")
    @Column(name = "RH36_COD_LOTACAO_REAL")
    private Long id;

    @Column(name = "RH36_NOME")
    private String nome;

    @Column(name = "RH36_TELEFONE")
    private String telefone;

    @Column(name = "RH36_COD_SIISP")
    private Integer codigoSiisp;

    @Column(name = "RH36_SIGLA")
    private String sigla;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RH36_DATA_CADASTRO")
    private Date dataCadastro;

    @OneToOne
    @JoinColumn(name = "FKRH36RH32_COD_TIPO_LOTACAO")
    private TipoLotacao tipoLotacao;

    @OneToOne
    @JoinColumn(name = "FKRH36RH36_COD_LOTACAO_MAE")
    private LotacaoReal lotacaoMae;

    @OneToOne
    @JoinColumn(name = "FKRH36CG20_COD_PREDIO")
    private Predio predio;

    @ManyToOne
    @JoinColumn(name = "FKRH36RH02_COD_SERVIDOR")
    private Servidor servidor;

    @OneToMany( cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FKRH03RH36_COD_LOTACAO_REAL")
    private List<LotacaoFolha> lotacoesFolha;

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getCodigoSiisp() {
        return codigoSiisp;
    }

    public void setCodigoSiisp(Integer codigoSiisp) {
        this.codigoSiisp = codigoSiisp;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public TipoLotacao getTipoLotacao() {
        return tipoLotacao;
    }

    public void setTipoLotacao(TipoLotacao tipoLotacao) {
        this.tipoLotacao = tipoLotacao;
    }

    public LotacaoReal getLotacaoMae() {
        return lotacaoMae;
    }

    public void setLotacaoMae(LotacaoReal lotacaoMae) {
        this.lotacaoMae = lotacaoMae;
    }

    public Predio getPredio() {
        return predio;
    }

    public void setPredio(Predio predio) {
        this.predio = predio;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List<LotacaoFolha> getLotacoesFolha() {
        if(lotacoesFolha == null){
            lotacoesFolha = new ArrayList<LotacaoFolha>();
        }
        return lotacoesFolha;
    }

    public void setLotacoesFolha(List<LotacaoFolha> lotacoesFolha) {
        this.lotacoesFolha = lotacoesFolha;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LotacaoReal that = (LotacaoReal) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "LotacaoReal{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", codigoSiisp=" + codigoSiisp +
                ", sigla='" + sigla + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", tipoLotacao=" + tipoLotacao +
                ", lotacaoMae=" + lotacaoMae +
                ", predio=" + predio +
                ", servidor=" + servidor +
                ", lotacoesFolha=" + lotacoesFolha +
                '}';
    }
}
