package beans;

import facade.LotacaoRealFacade;
import model.*;
import org.primefaces.model.DualListModel;
import repository.*;
import util.JSFUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "lotacaoVMB")
@ViewScoped
public class LotacaoBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB
    private PredioRepository predioRepository;
    @EJB
    private TipoLotacaoRepository tipoLotacaoRepository;
    @EJB
    private LotacaoRealRepository lotacaoRealRepository;
    @EJB
    private LotacaoFolhaRepository lotacaoFolhaRepository;
    @EJB
    private ServidorRepository servidorRepository;
    @EJB
    private LotacaoRealFacade lotacaoRealFacade;

    private Collection<Predio> predios;
    private Collection<TipoLotacao> tipoLotacoes;
    private List<LotacaoFolha> lotacaoFolhas;
    private List<LotacaoFolha> lotacaoFolhasSelecionadas;
    private Collection<LotacaoReal> lotacaoReais;
    private DualListModel<LotacaoFolha> dualListModel;
    private LotacaoReal lotacaoReal;
    private LotacaoFolha lotacaoFolhaSelecionada;
    private String buscaNome;

    @PostConstruct
    public void init() {
        lotacaoReal = (LotacaoReal) JSFUtil.flashScope().get("lotacaoReal");
        if (lotacaoReal == null) {
            lotacaoReal = new LotacaoReal();
        } else {
            lotacaoReal = lotacaoRealRepository.getLotacaoRealCompleta(lotacaoReal);
        }
        predios = predioRepository.getPredios();
        tipoLotacoes = tipoLotacaoRepository.getTipoLotacoes();
        lotacaoReais = lotacaoRealRepository.getLotacoes();
        lotacaoFolhas = new ArrayList<LotacaoFolha>();
        lotacaoFolhasSelecionadas = new ArrayList<LotacaoFolha>();
        dualListModel = new DualListModel<LotacaoFolha>(lotacaoFolhas, (lotacaoReal != null) ? lotacaoReal.getLotacoesFolha() : lotacaoFolhasSelecionadas);
    }


    public LotacaoReal getLotacaoReal() {
        return lotacaoReal;
    }

    public void setLotacaoReal(LotacaoReal lotacaoReal) {
        this.lotacaoReal = lotacaoReal;
    }

    public Collection<Predio> getPredios() {
        return predios;
    }

    public void setPredios(Collection<Predio> predios) {
        this.predios = predios;
    }

    public Collection<TipoLotacao> getTipoLotacoes() {
        return tipoLotacoes;
    }

    public void setTipoLotacoes(Collection<TipoLotacao> tipoLotacoes) {
        this.tipoLotacoes = tipoLotacoes;
    }

    public Collection<LotacaoReal> getLotacaoReais() {
        return lotacaoReais;
    }

    public void setLotacaoReais(Collection<LotacaoReal> lotacaoReais) {
        this.lotacaoReais = lotacaoReais;
    }

    public List<LotacaoFolha> getLotacaoFolhas() {
        return lotacaoFolhas;
    }

    public void setLotacaoFolhas(List<LotacaoFolha> lotacaoFolhas) {
        this.lotacaoFolhas = lotacaoFolhas;
    }

    public LotacaoFolha getLotacaoFolhaSelecionada() {
        return lotacaoFolhaSelecionada;
    }

    public void setLotacaoFolhaSelecionada(LotacaoFolha lotacaoFolhaSelecionada) {
        this.lotacaoFolhaSelecionada = lotacaoFolhaSelecionada;
    }

    public DualListModel<LotacaoFolha> getDualListModel() {
        return dualListModel;
    }

    public void setDualListModel(DualListModel<LotacaoFolha> dualListModel) {
        this.dualListModel = dualListModel;
    }

    public List<LotacaoFolha> getLotacaoFolhasSelecionadas() {
        return lotacaoFolhasSelecionadas;
    }

    public void setLotacaoFolhasSelecionadas(List<LotacaoFolha> lotacaoFolhasSelecionadas) {
        this.lotacaoFolhasSelecionadas = lotacaoFolhasSelecionadas;
    }

    public String getBuscaNome() {
        return buscaNome;
    }

    public void setBuscaNome(String buscaNome) {
        this.buscaNome = buscaNome;
    }

    public void salvar(ActionEvent actionEvent) {
        lotacaoReal.setDataCadastro(new Date());
        lotacaoReal = lotacaoRealFacade.salvarLotacaoReal(lotacaoReal);
        JSFUtil.addDefaultSucessMessage();
    }

    public List<LotacaoReal> autoCompletarLotacaoMae(String nome) {
        return lotacaoRealRepository.getLotacoesMax(nome, 10);
    }

    public List<Servidor> autoCompletarServidor(String nome) {
        return servidorRepository.getServidorMax(nome, 10);
    }

    public void buscarLotacaoFolha(ActionEvent actionEvent) {
        lotacaoFolhas = new ArrayList<LotacaoFolha>();
        lotacaoFolhasSelecionadas = new ArrayList<LotacaoFolha>();
        lotacaoFolhas = lotacaoFolhaRepository.getLotacoes(buscaNome);
        lotacaoFolhas.removeAll(lotacaoReal.getLotacoesFolha());
        lotacaoFolhasSelecionadas.addAll(lotacaoReal.getLotacoesFolha());
        dualListModel = new DualListModel<LotacaoFolha>(lotacaoFolhas, lotacaoFolhasSelecionadas);
        JSFUtil.addDefaultSucessMessage();
    }

    public void inserirLotacaoFolha(ActionEvent actionEvent) {
        if (lotacaoReal.getLotacoesFolha() == null) {
            lotacaoReal.setLotacoesFolha(new ArrayList<LotacaoFolha>());
        }
        lotacaoReal.getLotacoesFolha().clear();
        lotacaoReal.getLotacoesFolha().addAll(dualListModel.getTarget());
        lotacaoReal = lotacaoRealFacade.salvarLotacaoReal(lotacaoReal);
        JSFUtil.addDefaultSucessMessage();
    }
}
