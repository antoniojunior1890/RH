package beans;

import facade.SituacaoFacade;
import model.Situacao;
import repository.SituacaoRepository;
import util.JSFUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.Collection;

@ManagedBean(name = "situacaoVMB")
@ViewScoped
public class SituacaoBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @EJB
    private SituacaoFacade situacaoFacade;
    @EJB
    private SituacaoRepository situacaoRepository;
    private Situacao situacao;
    private Collection<Situacao> situacoes;

    @PostConstruct
    public void init() {
        if (situacao == null) {
            situacao = new Situacao();
        }
        this.atualizarSituacao();
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Collection<Situacao> getSituacoes() {
        return situacoes;
    }

    public void setSituacoes(Collection<Situacao> situacoes) {
        this.situacoes = situacoes;
    }

    public void salvar(ActionEvent actionEvent) {
        situacaoFacade.salvarSituacao(situacao);
        atualizarSituacao();
        JSFUtil.addDefaultSucessMessage();
    }

    public void excluir(ActionEvent actionEvent) {
        situacaoFacade.excluirSituacao(situacao);
        situacao = new Situacao();
        atualizarSituacao();
        JSFUtil.addDefaultSucessMessage();
    }

    public void novo(ActionEvent actionEvent) {
        situacao = new Situacao();
    }

    public void atualizarSituacao() {
        situacoes = situacaoRepository.getSituacoes();
    }

}
