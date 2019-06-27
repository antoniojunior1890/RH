package beans;

import facade.ServidorFacade;
import model.*;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import repository.*;
import util.GenericLazyDataModel;
import util.JSFUtil;
import util.LazyFilterable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "acompanhamentoServidorVMB")
@ViewScoped
public class AcompanhamentoServidorBean implements LazyFilterable<Servidor>, Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private ServidorFacade servidorFacade;
    @EJB
    private ServidorRepository servidorRepository;
    @EJB
    private TipoVinculoRepository tipoVinculoRepository;
    @EJB
    private SituacaoRepository situacaoRepository;
    @EJB
    private CargoRepository cargoRepository;
    @EJB
    private LotacaoRealRepository lotacaoRepository;
    @EJB
    private FuncaoRepository funcaoRepository;

    private Collection<TipoVinculo> tipoVinculos;
    private Collection<Situacao> situacoes;
    private Collection<Cargo> cargos;
    private Collection<LotacaoReal> lotacoes;
    private Collection<Funcao> funcoes;
    private LazyDataModel<Servidor> lazyDataModel;

    private Servidor servidor;

    private String buscaNome;
    private String buscaCpf;
    private Integer buscaMatricula;
    private Cargo buscaCargo;
    private Funcao buscaFuncao;
    private LotacaoReal buscaLotacaoReal;
    private TipoVinculo buscaTipoVinculo;
    private Situacao buscaSituacao;
    private List<Servidor> servidoresSelecionados;


    @PostConstruct
    public void init() {
        if (servidor == null) {
            servidor = new Servidor();
        }
        cargos = cargoRepository.getCargos();
        tipoVinculos = tipoVinculoRepository.getTipoVinculos();
        lotacoes = lotacaoRepository.getLotacoes();
        funcoes = funcaoRepository.getFuncoes();
        situacoes = situacaoRepository.getSituacoes();
        servidoresSelecionados = new ArrayList<Servidor>();
        lazyDataModel = new GenericLazyDataModel<Servidor>(this);
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public String getBuscaNome() {
        return buscaNome;
    }

    public void setBuscaNome(String buscaNome) {
        this.buscaNome = buscaNome;
    }

    public String getBuscaCpf() {
        return buscaCpf;
    }

    public void setBuscaCpf(String buscaCpf) {
        this.buscaCpf = buscaCpf;
    }

    public Integer getBuscaMatricula() {
        return buscaMatricula;
    }

    public void setBuscaMatricula(Integer buscaMatricula) {
        this.buscaMatricula = buscaMatricula;
    }

    public Cargo getBuscaCargo() {
        return buscaCargo;
    }

    public void setBuscaCargo(Cargo buscaCargo) {
        this.buscaCargo = buscaCargo;
    }

    public Funcao getBuscaFuncao() {
        return buscaFuncao;
    }

    public void setBuscaFuncao(Funcao buscaFuncao) {
        this.buscaFuncao = buscaFuncao;
    }

    public LotacaoReal getBuscaLotacaoReal() {
        return buscaLotacaoReal;
    }

    public void setBuscaLotacaoReal(LotacaoReal buscaLotacaoReal) {
        this.buscaLotacaoReal = buscaLotacaoReal;
    }

    public TipoVinculo getBuscaTipoVinculo() {
        return buscaTipoVinculo;
    }

    public void setBuscaTipoVinculo(TipoVinculo buscaTipoVinculo) {
        this.buscaTipoVinculo = buscaTipoVinculo;
    }

    public Situacao getBuscaSituacao() {
        return buscaSituacao;
    }

    public void setBuscaSituacao(Situacao buscaSituacao) {
        this.buscaSituacao = buscaSituacao;
    }

    public Collection<LotacaoReal> getLotacoes() {
        return lotacoes;
    }

    public void setLotacoes(Collection<LotacaoReal> lotacoes) {
        this.lotacoes = lotacoes;
    }

    public Collection<Funcao> getFuncoes() {
        return funcoes;
    }

    public void setFuncoes(Collection<Funcao> funcoes) {
        this.funcoes = funcoes;
    }

    public Collection<TipoVinculo> getTipoVinculos() {
        return tipoVinculos;
    }

    public void setTipoVinculos(Collection<TipoVinculo> tipoVinculos) {
        this.tipoVinculos = tipoVinculos;
    }

    public Collection<Situacao> getSituacoes() {
        return situacoes;
    }

    public void setSituacoes(Collection<Situacao> situacoes) {
        this.situacoes = situacoes;
    }

    public Collection<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(Collection<Cargo> cargos) {
        this.cargos = cargos;
    }

    public List<Servidor> getServidoresSelecionados() {
        return servidoresSelecionados;
    }

    public void setServidoresSelecionados(List<Servidor> servidoresSelecionados) {
        this.servidoresSelecionados = servidoresSelecionados;
    }

    public LazyDataModel<Servidor> getLazyDataModel() {
        return lazyDataModel;
    }

    public void setLazyDataModel(LazyDataModel<Servidor> lazyDataModel) {
        this.lazyDataModel = lazyDataModel;
    }

    public String onClickServidor() {
        if (servidor.getSituacao().getId().equals(Situacao.ID_PRE_CADASTRADO)) {
            JSFUtil.flashScope().put("servidor", servidor);
            return "servidor?faces-redirect=true";
        } else {
            JSFUtil.addErrorMessage("* Edição permitida apenas para servidores com status de PRÉ CADASTRADO.");
            return null;
        }
    }

    public void buscarServidor(ActionEvent actionEvent) {
    }

    @Override
    public List<Servidor> tableFilter(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        lazyDataModel.setRowCount(servidorRepository.getServidorCount(null, buscaNome, buscaCpf, buscaCargo, buscaTipoVinculo, buscaLotacaoReal, buscaFuncao, buscaSituacao, null).intValue());
        return servidorRepository.getServidor(null, buscaNome, buscaCpf, buscaCargo, buscaTipoVinculo, buscaLotacaoReal, buscaFuncao, buscaSituacao, null, first, pageSize);
    }

    public void solicitarMatricula(ActionEvent actionEvent) {
        for (Servidor servidor : servidoresSelecionados) {
            if (servidor.getSituacao().getId() == Situacao.ID_PRE_CADASTRADO) {
                Situacao situacao = new Situacao();
                situacao.setId(Situacao.ID_MATRICULA_PRE_SOLICITADA);
                servidor.setSituacao(situacao);
                servidorFacade.salvarServidor(servidor);
            } else {
                JSFUtil.addErrorMessage("* Matricula deste servidor já foi solicitada.");
            }
        }
    }
}
