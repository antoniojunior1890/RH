package beans;

import facade.FuncaoFacade;
import model.Funcao;
import repository.FuncaoRepository;
import util.JSFUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.Collection;

@ManagedBean(name = "funcaoVMB")
@ViewScoped
public class FuncaoBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @EJB
    private FuncaoFacade funcaoFacade;
    @EJB
    private FuncaoRepository funcaoRepository;
    private Collection<Funcao> funcoes;
    private Funcao funcao;

    @PostConstruct
    public void init() {
        if (funcao == null) {
            funcao = new Funcao();
        }
        atualizarFuncoes();
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public Collection<Funcao> getFuncoes() {
        return funcoes;
    }

    public void setFuncoes(Collection<Funcao> funcoes) {
        this.funcoes = funcoes;
    }

    public void salvar(ActionEvent actionEvent) {
        funcaoFacade.salvarFuncao(funcao);
        atualizarFuncoes();
        JSFUtil.addDefaultSucessMessage();
    }

    public void excluir(ActionEvent actionEvent) {
        funcaoFacade.excluirFuncao(funcao);
        funcao = new Funcao();
        atualizarFuncoes();
        JSFUtil.addDefaultSucessMessage();
    }

    public void novo(ActionEvent actionEvent) {
        funcao = new Funcao();
    }

    public void atualizarFuncoes() {
        funcoes = funcaoRepository.getFuncoes();

    }
}
