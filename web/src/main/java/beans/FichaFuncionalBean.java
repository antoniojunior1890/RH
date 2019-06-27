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
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "FichaFuncionalVMB")
@ViewScoped
public class FichaFuncionalBean implements LazyFilterable<Servidor>, Serializable {

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
    private LotacaoFolhaRepository lotacaoRepository;
    @EJB
    private FuncaoRepository funcaoRepository;

    private Collection<Servidor> servidores;
    private Collection<TipoVinculo> tipoVinculos;
    private Collection<Situacao> situacoes;
    private Collection<Cargo> cargos;
    private Collection<LotacaoFolha> lotacoes;
    private Collection<Funcao> funcoes;
    private LazyDataModel<Servidor> lazyDataModel;

    private Servidor servidor;

    private String buscaNome;
    private String buscaCpf;
    private String buscaMatricula;
    private List<Servidor> servidorList;


    @PostConstruct
    public void init() {
        if (servidor == null) {
            servidor = new Servidor();
        }

        tipoVinculos = tipoVinculoRepository.getTipoVinculos();
        situacoes = situacaoRepository.getSituacoes();
        cargos = cargoRepository.getCargos();
        lotacoes = lotacaoRepository.getLotacoes();
        funcoes = funcaoRepository.getFuncoes();
        lotacoes = lotacaoRepository.getLotacoes();
        lazyDataModel = new GenericLazyDataModel<Servidor>(this);
    }


    public Collection<Servidor> getServidores() {
        return servidores;
    }

    public void setServidores(Collection<Servidor> servidores) {
        this.servidores = servidores;
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

    public String getBuscaMatricula() {
        return buscaMatricula;
    }

    public void setBuscaMatricula(String buscaMatricula) {
        this.buscaMatricula = buscaMatricula;
    }

    public Collection<LotacaoFolha> getLotacoes() {
        return lotacoes;
    }

    public void setLotacoes(Collection<LotacaoFolha> lotacoes) {
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

    public List<Servidor> getServidorList() {
        return servidorList;
    }

    public void setServidorList(List<Servidor> servidorList) {
        this.servidorList = servidorList;
    }

    public LazyDataModel<Servidor> getLazyDataModel() {
        return lazyDataModel;
    }

    public void setLazyDataModel(LazyDataModel<Servidor> lazyDataModel) {
        this.lazyDataModel = lazyDataModel;
    }

    public String onClickServidorFicha() {
        servidor = servidorRepository.getServidoresFormacoes(servidor.getId());
        JSFUtil.flashScope().put("servidorVisualizar", servidor);
        return "visualizarFicha?faces-redirect=true";
    }

    public void buscarServidorFicha() {
    }

    @Override
    public List<Servidor> tableFilter(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        lazyDataModel.setRowCount(servidorRepository.getServidorCount(buscaMatricula, buscaNome, buscaCpf, null, null, null, null, null, null).intValue());
        return servidorRepository.getServidor(buscaMatricula, buscaNome, buscaCpf, null, null, null, null, null, null, first, pageSize);
    }
}
