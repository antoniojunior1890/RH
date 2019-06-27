package beans;

import facade.FormacaoFacade;
import model.Formacao;
import repository.FormacaoRepository;
import util.JSFUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.Collection;

@ManagedBean(name = "formacaoVMB")
@ViewScoped
public class FormacaoBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @EJB
    private FormacaoFacade formacaoFacade;
    @EJB
    private FormacaoRepository formacaoRepository;
    private Collection<Formacao> formacoes;
    private Formacao formacao;

    @PostConstruct
    public void init() {
        if (formacao == null) {
            formacao = new Formacao();
        }
        atualizarFormacao();
    }

    public Formacao getFormacao() {
        return formacao;
    }

    public void setFormacao(Formacao formacao) {
        this.formacao = formacao;
    }

    public Collection<Formacao> getFormacoes() {
        return formacoes;
    }

    public void setFormacoes(Collection<Formacao> formacoes) {
        this.formacoes = formacoes;
    }

    public void salvar(ActionEvent actionEvent) {
        formacaoFacade.salvarFormacao(formacao);
        atualizarFormacao();
        JSFUtil.addDefaultSucessMessage();
    }

    public void excluir(ActionEvent actionEvent) {
        formacaoFacade.excluirFormacao(formacao);
        formacao = new Formacao();
        atualizarFormacao();
        JSFUtil.addDefaultSucessMessage();
    }

    public void novo(ActionEvent actionEvent) {
        formacao = new Formacao();
    }

    public void atualizarFormacao() {
        //formacoes = formacaoRepository.getFormacoes();
    }
}
