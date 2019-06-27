package beans;

import facade.ContratoFacade;
import facade.ServidorFacade;
import model.*;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import repository.*;
import util.JSFUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@ManagedBean(name = "visualizarFichaVMB")
@ViewScoped
public class VisualizarFichaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    ServidorLotacaoRepository servidorLotacaoRepository;
    @EJB
    ServidorRepository servidorRepository;
    @EJB
    FormacaoRepository formacaoRepository;
    @EJB
    MunicipioRepository municipioRepository;
    @EJB
    AreaRepository areaRepository;
    @EJB
    NivelFormacaoRepository nivelFormacaoRepository;
    @EJB
    StatusFormacaoRepository statusFormacaoRepository;
    @EJB
    ParentescoRepository parentescoRepository;
    @EJB
    BancoRepository bancoRepository;
    @EJB
    ContratoRepository contratoRepository;
    @EJB
    ContratoFacade contratoFacade;
    @EJB
    ServidorFacade servidorFacade;

    private Servidor servidor;
    private ServidorLotacao servidorLotacao;
    private Integer activeTab;
    private Collection<LotacaoFolha> lotacoes;
    private Collection<ServidorLotacao> servidorLotacoes;
    private Collection<Formacao> formacoes;
    private Collection<Municipio> municipiosNascimento;
    private Collection<Municipio> municipiosEndereco;
    private Formacao formacao;
    private Dependente dependente;
    private DadosBancarios conta;
    private Collection<Area> areas;
    private Collection<NivelFormacao> niveisFormacoes;
    private Collection<StatusFormacao> statusFormacoes;
    private Collection<Parentesco> parentescos;
    private Collection<Banco> bancos;
    private UploadedFile arquivoUF;
    private Documento documento;
    private StreamedContent fileDown;
    private Boolean flagPeriodoVigencia;
    private List<Contrato> contratos;
    private Contrato contrato;

    @PostConstruct
    public void init() {
        servidor = (Servidor) JSFUtil.flashScope().get("servidorVisualizar");
        if (servidor != null) {
            servidor = servidorRepository.getServidorCompleto(servidor);
            formacoes = new HashSet<Formacao>(formacaoRepository.getFormacoes(servidor.getPessoa()));
            servidorLotacoes = servidorLotacaoRepository.getServidorLotacoesAtivo(servidor);
            municipiosNascimento = municipioRepository.getMunicipios(servidor.getPessoa().getUfNascimento());
            municipiosEndereco = municipioRepository.getMunicipios(servidor.getPessoa().getUfEndereco());
            contratos = contratoRepository.getContratos(servidor);
            if (contratos.size() > 0) {
                contrato = contratos.get(0);
            }
        }
        if (formacao == null) {
            formacao = new Formacao();
        }
        if (dependente == null) {
            dependente = new Dependente();
        }
        if (servidorLotacao == null) {
            servidorLotacao = new ServidorLotacao();
        }
        if (conta == null) {
            conta = new DadosBancarios();
        }
        areas = areaRepository.getAreas();
        niveisFormacoes = nivelFormacaoRepository.getNivelFormacoes();
        statusFormacoes = statusFormacaoRepository.getStatusFormacoes();
        parentescos = parentescoRepository.getParentescos();
        bancos = bancoRepository.getBancos();
        flagPeriodoVigencia = Boolean.FALSE;
        onSelectPeriodoVigencia();
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    public Boolean getFlagPeriodoVigencia() {
        return flagPeriodoVigencia;
    }

    public void setFlagPeriodoVigencia(Boolean flagPeriodoVigencia) {
        this.flagPeriodoVigencia = flagPeriodoVigencia;
    }

    public Integer getActiveTab() {
        return activeTab;
    }

    public void setActiveTab(Integer activeTab) {
        this.activeTab = activeTab;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public Collection<LotacaoFolha> getLotacoes() {
        return lotacoes;
    }

    public void setLotacoes(Collection<LotacaoFolha> lotacoes) {
        this.lotacoes = lotacoes;
    }

    public Collection<ServidorLotacao> getServidorLotacoes() {
        return servidorLotacoes;
    }

    public void setServidorLotacoes(Collection<ServidorLotacao> servidorLotacoes) {
        this.servidorLotacoes = servidorLotacoes;
    }

    public ServidorLotacao getServidorLotacao() {
        return servidorLotacao;
    }

    public void setServidorLotacao(ServidorLotacao servidorLotacao) {
        this.servidorLotacao = servidorLotacao;
    }

    public Collection<Formacao> getFormacoes() {
        return formacoes;
    }

    public void setFormacoes(Collection<Formacao> formacoes) {
        this.formacoes = formacoes;
    }

    public Collection<Municipio> getMunicipiosNascimento() {
        return municipiosNascimento;
    }

    public void setMunicipiosNascimento(Collection<Municipio> municipiosNascimento) {
        this.municipiosNascimento = municipiosNascimento;
    }

    public Collection<Municipio> getMunicipiosEndereco() {
        return municipiosEndereco;
    }

    public void setMunicipiosEndereco(Collection<Municipio> municipiosEndereco) {
        this.municipiosEndereco = municipiosEndereco;
    }

    public Formacao getFormacao() {
        return formacao;
    }

    public void setFormacao(Formacao formacao) {
        this.formacao = formacao;
    }

    public Dependente getDependente() {
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }

    public DadosBancarios getConta() {
        return conta;
    }

    public void setConta(DadosBancarios conta) {
        this.conta = conta;
    }

    public Collection<Area> getAreas() {
        return areas;
    }

    public void setAreas(Collection<Area> areas) {
        this.areas = areas;
    }

    public Collection<NivelFormacao> getNiveisFormacoes() {
        return niveisFormacoes;
    }

    public void setNiveisFormacoes(Collection<NivelFormacao> niveisFormacoes) {
        this.niveisFormacoes = niveisFormacoes;
    }

    public Collection<StatusFormacao> getStatusFormacoes() {
        return statusFormacoes;
    }

    public void setStatusFormacoes(Collection<StatusFormacao> statusFormacoes) {
        this.statusFormacoes = statusFormacoes;
    }

    public Collection<Parentesco> getParentescos() {
        return parentescos;
    }

    public void setParentescos(Collection<Parentesco> parentescos) {
        this.parentescos = parentescos;
    }

    public Collection<Banco> getBancos() {
        return bancos;
    }

    public void setBancos(Collection<Banco> bancos) {
        this.bancos = bancos;
    }

    public UploadedFile getArquivoUF() {
        return arquivoUF;
    }

    public void setArquivoUF(UploadedFile arquivoUF) {
        this.arquivoUF = arquivoUF;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public StreamedContent getFileDown() {
        return fileDown;
    }

    public void setFileDown(StreamedContent fileDown) {
        this.fileDown = fileDown;
    }

    public void onSelectPeriodoVigencia() {
        if (servidor.getTipoVinculo() != null && servidor.getTipoVinculo().getId() == TipoVinculo.ID_CONTRATADO) {
            flagPeriodoVigencia = Boolean.TRUE;
        } else {
            flagPeriodoVigencia = Boolean.FALSE;
        }
    }

    public void inserirDataDemissao() {
        if (servidor.getTipoVinculo().getId() == TipoVinculo.ID_CONTRATADO) {
            if (contrato == null) {
                contrato = new Contrato();
            }
            if (contratos == null) {
                contratos = new ArrayList<Contrato>();
            }


            contrato.setDataFim(servidor.getDataDemissao());
            contratos.add(contratoFacade.salvarContrato(contrato));
            servidor.setContratos(contratos);
        }
        servidor = servidorFacade.salvarServidor(servidor);
        JSFUtil.addDefaultSucessMessage();
    }
}
