package beans;

import model.LotacaoReal;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import repository.LotacaoRealRepository;
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
@ManagedBean(name = "acompanhamentoLotacaoVMB")
@ViewScoped
public class AcompanhamentoLotacaoBean implements LazyFilterable<LotacaoReal>, Serializable {
    private static final long serialVersionUID = 1L;


    @EJB
    private LotacaoRealRepository lotacaoRealRepository;
    private LazyDataModel<LotacaoReal> lotacoes;
    private LotacaoReal lotacaoReal;
    private String buscaNome;
    private Boolean flagBotaoNovo;

    @PostConstruct
    public void init() {
        flagBotaoNovo = Boolean.FALSE;
        lotacoes = new GenericLazyDataModel<LotacaoReal>(this);
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

    public Boolean getFlagBotaoNovo() {
        return flagBotaoNovo;
    }

    public void setFlagBotaoNovo(Boolean flagBotaoNovo) {
        this.flagBotaoNovo = flagBotaoNovo;
    }

    public LazyDataModel<LotacaoReal> getLotacoes() {
        return lotacoes;
    }

    public void setLotacoes(LazyDataModel<LotacaoReal> lotacoes) {
        this.lotacoes = lotacoes;
    }

    public void buscarLotacao(ActionEvent actionEvent) {
        flagBotaoNovo = Boolean.FALSE;
    }

    public String onClickLotacao() {
        JSFUtil.flashScope().put("lotacaoReal", lotacaoReal);
        return "lotacao?faces-redirect=true";
    }

    @Override
    public List<LotacaoReal> tableFilter(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        lotacoes.setRowCount(lotacaoRealRepository.getLotacoesCount(buscaNome).intValue());
        List<LotacaoReal> list = lotacaoRealRepository.getLotacoes(buscaNome, first, pageSize);
        if (buscaNome != null && list.isEmpty()) {
            flagBotaoNovo = Boolean.TRUE;
        }
        return list;
    }
}
