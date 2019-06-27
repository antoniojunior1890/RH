package beans;

import facade.NivelFormacaoFacade;
import model.NivelFormacao;
import repository.NivelFormacaoRepository;
import util.JSFUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.Collection;

@ManagedBean(name = "nivelFormacaoVMB")
@ViewScoped
public class NivelFormacaoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private NivelFormacaoFacade nivelFormacaoFacade;
    @EJB
    private NivelFormacaoRepository nivelFormacaoRepository;
    private Collection<NivelFormacao> nivelFormacoes;
    private NivelFormacao nivelFormacao;

    @PostConstruct
    public void init() {
        if (nivelFormacao == null) {
            nivelFormacao = new NivelFormacao();
        }
        atualizarNivelFormacao();
    }

    public NivelFormacao getNivelFormacao() {
        return nivelFormacao;
    }

    public void setNivelFormacao(NivelFormacao nivelFormacao) {
        this.nivelFormacao = nivelFormacao;
    }

    public Collection<NivelFormacao> getNivelFormacoes() {
        return nivelFormacoes;
    }

    public void setNivelFormacoes(Collection<NivelFormacao> nivelFormacoes) {
        this.nivelFormacoes = nivelFormacoes;
    }

    public void salvar(ActionEvent actionEvent) {
        nivelFormacaoFacade.salvarNivelFormacao(nivelFormacao);
        atualizarNivelFormacao();
        JSFUtil.addDefaultSucessMessage();
    }

    public void excluir(ActionEvent actionEvent) {
        nivelFormacaoFacade.excluirNivelFormacao(nivelFormacao);
        nivelFormacao = new NivelFormacao();
        atualizarNivelFormacao();
        JSFUtil.addDefaultSucessMessage();
    }

    public void novo(ActionEvent actionEvent) {
        nivelFormacao = new NivelFormacao();
    }

    public void atualizarNivelFormacao() {
        nivelFormacoes = nivelFormacaoRepository.getNivelFormacoes();
    }

}
