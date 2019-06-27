package beans;

import facade.StatusFormacaoFacade;
import model.StatusFormacao;
import repository.StatusFormacaoRepository;
import util.JSFUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.Collection;

@ManagedBean(name = "statusFormacaoVMB")
@ViewScoped
public class StatusFormacaoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private StatusFormacaoFacade statusFormacaoFacade;
    @EJB
    private StatusFormacaoRepository statusFormacaoRepository;
    private Collection<StatusFormacao> statusFormacoes;
    private StatusFormacao statusFormacao;

    @PostConstruct
    public void init() {
        if (statusFormacao == null) {
            statusFormacao = new StatusFormacao();
        }
        atualizarStatusFormacoes();
    }


    public StatusFormacao getStatusFormacao() {
        return statusFormacao;
    }


    public void setStatusFormacao(StatusFormacao statusFormacao) {
        this.statusFormacao = statusFormacao;
    }


    public Collection<StatusFormacao> getStatusFormacoes() {
        return statusFormacoes;
    }


    public void setStatusFormacoes(Collection<StatusFormacao> statusFormacoes) {
        this.statusFormacoes = statusFormacoes;
    }


    public void salvar(ActionEvent actionEvent) {
        statusFormacaoFacade.salvarStatusFormacao(statusFormacao);
        atualizarStatusFormacoes();
        JSFUtil.addDefaultSucessMessage();
    }

    public void excluir(ActionEvent actionEvent) {
        statusFormacaoFacade.excluirStatusFormacao(statusFormacao);
        statusFormacao = new StatusFormacao();
        atualizarStatusFormacoes();
        JSFUtil.addDefaultSucessMessage();
    }

    public void novo(ActionEvent actionEvent) {
        statusFormacao = new StatusFormacao();
    }

    public void atualizarStatusFormacoes() {
        statusFormacoes = statusFormacaoRepository.getStatusFormacoes();
    }

}
