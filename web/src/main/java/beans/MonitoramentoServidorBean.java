package beans;

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
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Renan on 14/07/16.
 */
@ManagedBean(name = "monitoramentoServidorVMB")
@ViewScoped
public class MonitoramentoServidorBean implements LazyFilterable<Servidor>, Serializable {
    private static final long serialVersionUID = 1L;


    @EJB
    private ServidorRepository servidorRepository;
    @EJB
    private LotacaoRealRepository lotacaoRealRepository;
    private LazyDataModel<Servidor> servidores;
    private String buscaNome;
    private Boolean comLotacao;
    private Servidor servidor;

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

    public LazyDataModel<Servidor> getServidores() {
        return servidores;
    }

    public void setServidores(LazyDataModel<Servidor> servidores) {
        this.servidores = servidores;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public Boolean getComLotacao() {
        return comLotacao;
    }

    public void setComLotacao(Boolean comLotacao) {
        this.comLotacao = comLotacao;
    }

    public String onClickServidor() {
        JSFUtil.flashScope().put("servidor", servidor);
        return "lotacaoServidor?faces-redirect=true";
    }

    @Override
    public List<Servidor> tableFilter(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        servidores.setRowCount(servidorRepository.getServidorCount(null, null, null, null, null, null, null, null, comLotacao).intValue());
        return servidorRepository.getServidor(null, null, null, null, null, null, null, null, comLotacao, first, pageSize);
    }
}
