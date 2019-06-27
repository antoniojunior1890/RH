package beans;

import model.LotacaoReal;
import model.Servidor;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import repository.LotacaoRealRepository;
import repository.ServidorRepository;
import util.GenericLazyDataModel;
import util.JSFUtil;
import util.LazyFilterable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Renan on 14/07/16.
 */
@ManagedBean(name = "monitoramentoLotacaoVMB")
@ViewScoped
public class MonitoramentoLotacaoBean implements LazyFilterable<Servidor>, Serializable {
    private static final long serialVersionUID = 1L;


    @EJB
    private LotacaoRealRepository lotacaoRealRepository;
    @EJB
    private ServidorRepository servidorRepository;
    private LazyDataModel<Servidor> servidores;
    private LotacaoReal lotacaoReal;
    private String buscaNome;

    @PostConstruct
    public void init() {
        servidores = new GenericLazyDataModel<Servidor>(this);
    }

    public String getBuscaNome() {
        return buscaNome;
    }

    public void setBuscaNome(String buscaNome) {
        this.buscaNome = buscaNome;
    }

    public LotacaoReal getLotacaoReal() {
        return lotacaoReal;
    }

    public void setLotacaoReal(LotacaoReal lotacaoReal) {
        this.lotacaoReal = lotacaoReal;
    }

    public LazyDataModel<Servidor> getServidores() {
        return servidores;
    }

    public void setServidores(LazyDataModel<Servidor> servidores) {
        this.servidores = servidores;
    }

    public List<LotacaoReal> autoCompletarLotacaoReal(String nome) {
        return lotacaoRealRepository.getLotacoesMax(nome, 10);
    }

    @Override
    public List<Servidor> tableFilter(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        servidores.setRowCount(servidorRepository.getServidorCount(null, null, null, null, null, lotacaoReal, null, null, null).intValue());
        return servidorRepository.getServidor(null, null, null, null, null, lotacaoReal, null, null, null, first, pageSize);
    }
}
