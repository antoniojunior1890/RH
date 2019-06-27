package beans;

import facade.LotacaoRealFacade;
import model.*;
import org.primefaces.model.DualListModel;
import repository.*;
import util.JSFUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "lotacaoServidorVMB")
@ViewScoped
public class LotacaoServidorBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB
    private LotacaoRealRepository lotacaoRealRepository;
    @EJB
    private FuncaoRepository funcaoRepository;
    private Servidor servidor;
    private String buscaNome;
    private List<LotacaoReal> lotacoes;
    private LotacaoReal lotacaoReal;
    private Funcao funcao;

    @PostConstruct
    public void init() {
        servidor = (Servidor) JSFUtil.flashScope().get("servidor");
        if (servidor == null) {
            servidor = new Servidor();
        }
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public String getBuscaNome() {
        return buscaNome;
    }

    public void setBuscaNome(String buscaNome) {
        this.buscaNome = buscaNome;
    }

    public List<LotacaoReal> getLotacoes() {
        return lotacoes;
    }

    public void setLotacoes(List<LotacaoReal> lotacoes) {
        this.lotacoes = lotacoes;
    }

    public LotacaoReal getLotacaoReal() {
        return lotacaoReal;
    }

    public void setLotacaoReal(LotacaoReal lotacaoReal) {
        this.lotacaoReal = lotacaoReal;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public List<LotacaoReal> autoCompletarLotacaoReal(String nome) {
        return lotacaoRealRepository.getLotacoesMax(nome, 10);
    }

    public List<Funcao> autoCompletarFuncao(String nome) {
        return funcaoRepository.getFuncoesMax(nome, 10);
    }

    public void salvar(ActionEvent actionEvent) {
        JSFUtil.addDefaultSucessMessage();
    }
}
