package model;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "RH14_SERVIDOR_LOTACAO")
@SequenceGenerator(name = "RH14_SQC", sequenceName = "RH14_SQC", allocationSize = 1, initialValue = 1)
public class ServidorLotacao implements Serializable, AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RH14_SQC")
	@Column(name = "RH14_COD_SERVIDOR_LOTACAO")
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RH14_DATA_APRESENTACAO")
	private Date dataApresentacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RH14_DATA_DESLIGAMENTO")
	private Date dataDesligamento;
	
	@Column(name = "RH14_ATIVA")
	private Integer ativa;

	@OneToOne
	@JoinColumn(name = "FKRH14RH36_COD_LOTACAO_REAL")
	private LotacaoReal lotacaoReal;
	
	@OneToOne
	@JoinColumn(name = "FKRH14RH06_COD_FUNCAO")
	private Funcao funcao;

	@OneToOne
	@JoinColumn(name = "FKRH14RH31_COD_STATUS_APRESENTACAO")
	private StatusApresentacao statusApresentacao;

	@OneToOne
	@JoinColumn(name = "FKRH14RH34_COD_CLASSE_LOTACAO")
	private ClasseLotacao classeLotacao;

    @OneToOne
    @JoinColumn(name = "FKRH14RH35_COD_SIMBOLOGIA")
    private Simbologia simbologia;

    @ManyToOne
    @JoinColumn(name = "FKRH14RH02_COD_SERVIDOR")
    private Servidor servidor;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataApresentacao() {
        return dataApresentacao;
    }

    public void setDataApresentacao(Date dataApresentacao) {
        this.dataApresentacao = dataApresentacao;
    }

    public Date getDataDesligamento() {
        return dataDesligamento;
    }

    public void setDataDesligamento(Date dataDesligamento) {
        this.dataDesligamento = dataDesligamento;
    }

    public Integer getAtiva() {
        return ativa;
    }

    public void setAtiva(Integer ativa) {
        this.ativa = ativa;
    }

    public LotacaoReal getLotacaoReal() {
        return lotacaoReal;
    }

    public void setLotacaoReal(LotacaoReal lotacaoReal) {
        this.lotacaoReal = lotacaoReal;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public StatusApresentacao getStatusApresentacao() {
        return statusApresentacao;
    }

    public void setStatusApresentacao(StatusApresentacao statusApresentacao) {
        this.statusApresentacao = statusApresentacao;
    }

    public ClasseLotacao getClasseLotacao() {
        return classeLotacao;
    }

    public void setClasseLotacao(ClasseLotacao classeLotacao) {
        this.classeLotacao = classeLotacao;
    }

    public Simbologia getSimbologia() {
        return simbologia;
    }

    public void setSimbologia(Simbologia simbologia) {
        this.simbologia = simbologia;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServidorLotacao that = (ServidorLotacao) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ServidorLotacao{" +
                "id=" + id +
                ", dataApresentacao=" + dataApresentacao +
                ", dataDesligamento=" + dataDesligamento +
                ", ativa=" + ativa +
                ", lotacaoReal=" + lotacaoReal +
                ", funcao=" + funcao +
                ", statusApresentacao=" + statusApresentacao +
                ", classeLotacao=" + classeLotacao +
                ", simbologia=" + simbologia +
                ", servidor=" + servidor +
                '}';
    }
}
