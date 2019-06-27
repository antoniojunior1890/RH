package beans;

import model.LotacaoFolha;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import repository.LotacaoFolhaRepository;
import repository.LotacaoRealRepository;
import util.GenericLazyDataModel;
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
@ManagedBean(name = "acompanhamentoLotacaoFolhaVMB")
@ViewScoped
public class AcompanhamentoLotacaoFolhaBean implements LazyFilterable<LotacaoFolha>, Serializable {
    private static final long serialVersionUID = 1L;


    @EJB
    private LotacaoRealRepository lotacaoRealRepository;
    @EJB
    private LotacaoFolhaRepository lotacaoFolhaRepository;

    private LazyDataModel<LotacaoFolha> lotacoes;
    private LotacaoFolha lotacaoFolha;
    private String buscaNome;
    private String buscaOrgao;
    private Boolean vinculada;
    private Boolean flagBotaoNovo;

    @PostConstruct
    public void init() {
        flagBotaoNovo = Boolean.FALSE;
        lotacoes = new GenericLazyDataModel<LotacaoFolha>(this);
    }

    public String getBuscaNome() {
        return buscaNome;
    }

    public void setBuscaNome(String buscaNome) {
        this.buscaNome = buscaNome;
    }

    public String getBuscaOrgao() {
        return buscaOrgao;
    }

    public void setBuscaOrgao(String buscaOrgao) {
        this.buscaOrgao = buscaOrgao;
    }

    public Boolean getVinculada() {
        return vinculada;
    }

    public void setVinculada(Boolean vinculada) {
        this.vinculada = vinculada;
    }

    public LotacaoFolha getLotacaoFolha() {
        return lotacaoFolha;
    }

    public void setLotacaoFolha(LotacaoFolha lotacaoFolha) {
        this.lotacaoFolha = lotacaoFolha;
    }

    public Boolean getFlagBotaoNovo() {
        return flagBotaoNovo;
    }

    public void setFlagBotaoNovo(Boolean flagBotaoNovo) {
        this.flagBotaoNovo = flagBotaoNovo;
    }

    public LazyDataModel<LotacaoFolha> getLotacoes() {
        return lotacoes;
    }

    public void setLotacoes(LazyDataModel<LotacaoFolha> lotacoes) {
        this.lotacoes = lotacoes;
    }

    public void buscarLotacao(ActionEvent actionEvent) {
        flagBotaoNovo = Boolean.FALSE;
    }

    @Override
    public List<LotacaoFolha> tableFilter(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        lotacoes.setRowCount(lotacaoFolhaRepository.getLotacoesCount(buscaNome, buscaOrgao, vinculada).intValue());
        List<LotacaoFolha> list = lotacaoFolhaRepository.getLotacoes(buscaNome, buscaOrgao, vinculada, first, pageSize);
        if ((buscaNome != null || buscaOrgao != null) && list.isEmpty()) {
            flagBotaoNovo = Boolean.TRUE;
        }
        return list;
    }
}
