package beans;

import facade.TipoLotacaoFacade;
import model.TipoLotacao;
import repository.TipoLotacaoRepository;
import util.JSFUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by antonio on 15/07/16.
 */

@ManagedBean(name = "tipoLotacaoVMB")
@ViewScoped
public class TipoLotacaoBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @EJB
    private TipoLotacaoFacade tipoLotacaoFacade;
    @EJB
    private TipoLotacaoRepository tipoLotacaoRepository;
    private Collection<TipoLotacao> tipoLotacoes;
    private TipoLotacao tipoLotacao;

    @PostConstruct
    public void init() {
        if (tipoLotacao == null) {
            tipoLotacao = new TipoLotacao();
        }
        atualizarTipoLotacoes();
    }

    public TipoLotacao getTipoLotacao() {
        return tipoLotacao;
    }

    public void setTipoLotacao(TipoLotacao tipoLotacao) {
        this.tipoLotacao = tipoLotacao;
    }

    public Collection<TipoLotacao> getTipoLotacoes() {
        return tipoLotacoes;
    }

    public void setTipoLotacoes(Collection<TipoLotacao> tipoLotacoes) {
        this.tipoLotacoes = tipoLotacoes;
    }

    public void salvar(ActionEvent actionEvent) {
        tipoLotacaoFacade.salvarTipoLotacaoFacade(tipoLotacao);
        atualizarTipoLotacoes();
        JSFUtil.addDefaultSucessMessage();
    }

    public void excluir(ActionEvent actionEvent) {
        tipoLotacaoFacade.excluirTipoLotacaoFacade(tipoLotacao);
        tipoLotacao = new TipoLotacao();
        atualizarTipoLotacoes();
        JSFUtil.addDefaultSucessMessage();
    }

    public void novo(ActionEvent actionEvent) {
        tipoLotacao = new TipoLotacao();
    }

    public void atualizarTipoLotacoes() {
        tipoLotacoes = tipoLotacaoRepository.getTipoLotacoes();
    }

}
