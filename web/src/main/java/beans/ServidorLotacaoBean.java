package beans;

import facade.ServidorLotacaoFacade;
import model.Servidor;
import model.ServidorLotacao;
import repository.ServidorRepository;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.util.Collection;

@ManagedBean(name = "servidorLotacaoVMB")
@ViewScoped
public class ServidorLotacaoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private ServidorLotacaoFacade servidorLotacaoFacade;
    @EJB
    private ServidorRepository servidorRepository;
    private ServidorLotacao servidorLotacao;
    private Collection<Servidor> servidores;
    private String buscaNome;
    private String buscaCpf;
    private String buscaMatricula;
    private String buscaCargo;
    private String buscaFuncao;
    private String buscaLotacao;

    @PostConstruct
    public void init() {
        if (servidorLotacao == null) {
            servidorLotacao = new ServidorLotacao();
        }
        //servidores = servidorRepository.getServidores();
    }

    public ServidorLotacao getServidorLotacao() {
        return servidorLotacao;
    }

    public void setServidorLotacao(ServidorLotacao servidorLotacao) {
        this.servidorLotacao = servidorLotacao;
    }

    public Collection<Servidor> getServidores() {
        return servidores;
    }

    public void setServidores(Collection<Servidor> servidores) {
        this.servidores = servidores;
    }

    public String getBuscaNome() {
        return buscaNome;
    }

    public void setBuscaNome(String buscaNome) {
        this.buscaNome = buscaNome;
    }

    public String getBuscaCpf() {
        return buscaCpf;
    }

    public void setBuscaCpf(String buscaCpf) {
        this.buscaCpf = buscaCpf;
    }

    public String getBuscaMatricula() {
        return buscaMatricula;
    }

    public void setBuscaMatricula(String buscaMatricula) {
        this.buscaMatricula = buscaMatricula;
    }

    public String getBuscaCargo() {
        return buscaCargo;
    }

    public void setBuscaCargo(String buscaCargo) {
        this.buscaCargo = buscaCargo;
    }

    public String getBuscaFuncao() {
        return buscaFuncao;
    }

    public void setBuscaFuncao(String buscaFuncao) {
        this.buscaFuncao = buscaFuncao;
    }

    public String getBuscaLotacao() {
        return buscaLotacao;
    }

    public void setBuscaLotacao(String buscaLotacao) {
        this.buscaLotacao = buscaLotacao;
    }

    public void buscarServidor() {
        //servidores = servidorRepository.getServidorNome(null, buscaNome, buscaCpf, buscaCargo, buscaFuncao, buscaLotacao);
        for (Servidor servidor : servidores) {
            System.out.println(servidor.getPessoa().getNome());
        }
    }

    public void de(AjaxBehaviorEvent event) {
        System.out.println("vai");
    }
}
