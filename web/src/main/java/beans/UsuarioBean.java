package beans;

import facade.UsuarioFacade;
import model.Usuario;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import repository.UsuarioRepository;
import security.UsuarioSistema;
import util.Criptografia;
import util.JSFUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

@ManagedBean(name = "usuarioSMB")
@SessionScoped
public class UsuarioBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB
    private UsuarioRepository usuarioRepository;
    @EJB
    private UsuarioFacade usuarioFacade;
    private Usuario usuario;
    private String cpf;
    private String senha;
    private Boolean senhaPadrao;
    private String confirmarSenha;
    private String nomeSobrenome;

    @PostConstruct
    public void init() {
        usuario = null;
    }

    public void login() throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) JSFUtil.getContext().getExternalContext().getRequest();
        HttpServletResponse httpServletResponse = (HttpServletResponse) JSFUtil.getContext().getExternalContext().getResponse();
        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/j_spring_security_check");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
        JSFUtil.getContext().responseComplete();
    }

    public String redefinirSenha() {
        usuario.setSenha(Criptografia.md5(senha));
        usuario = usuarioFacade.salvarUsuario(usuario);
        setUsuario(null);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "logout";
    }

    public String getNomeSobrenome() {
        if (usuario != null && usuario.getPessoa() != null) {
            String[] nomes = usuario.getPessoa().getNome().trim().split(" ");
            nomeSobrenome = nomes[0].concat(" " + nomes[nomes.length - 1]);
        }
        return nomeSobrenome;
    }

    public void setNomeSobrenome(String nomeSobrenome) {
        this.nomeSobrenome = nomeSobrenome;
    }

    public Usuario getUsuario() {
        if (usuario == null) {
            UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) JSFUtil.getContext().getExternalContext().getUserPrincipal();
            if (auth != null && auth.getPrincipal() != null) {
                usuario = ((UsuarioSistema) auth.getPrincipal()).getUsuario();
            }
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    public Boolean getSenhaPadrao() {
        senhaPadrao = Boolean.FALSE;
        if (usuario != null) {
            senhaPadrao = usuario.getSenha().equalsIgnoreCase(Usuario.senhaPadraoCriptografada);
        }
        return senhaPadrao;
    }

    public void setSenhaPadrao(Boolean senhaPadrao) {
        this.senhaPadrao = senhaPadrao;
    }

    public String onClickPrincipal() {
        return "";
    }

    public String onClickServidor() {
        return "servidor?faces-redirect=true";
    }

    public String onClickAcompanhamentoServidor() {
        return "acompanhamentoServidor?faces-redirect=true";
    }

    public String onClickFichaFuncional() {
        return "fichaFuncional?faces-redirect=true";
    }

    public String onClickPredio() {
        return "predio?faces-redirect=true";
    }

    public String onClickLotacao() {
        return "lotacao?faces-redirect=true";
    }

    public String onClickOrgao() {
        return "orgao?faces-redirect=true";
    }

    public String onClickFuncao() {
        return "funcao?faces-redirect=true";
    }

    public String onClickCargo() {
        return "cargo?faces-redirect=true";
    }

    public String onClickArea() {
        return "area?faces-redirect=true";
    }

    public String onClickCurso() {
        return "curso?faces-redirect=true";
    }

    public String onClickTipoVinculo() {
        return "tipoVinculo?faces-redirect=true";
    }

    public String onClickTipoLotacao() {
        return "tipoLotacao?faces-redirect=true";
    }

    public String onClickSituacao() {
        return "situacao?faces-redirect=true";
    }

    public String onClickAcompanhamentoLotacao() {
        return "acompanhamentoLotacao?faces-redirect=true";
    }

    public String onClickAcompanhamentoLotacaoFolha() {
        return "acompanhamentoLotacaoFolha?faces-redirect=true";
    }

    public String onClickRedefinirSenha() {
        return "senha?faces-redirect=true";
    }

    public String onClickSobre() {
        return "sobre?faces-redirect=true";
    }

    public String onClickAvisos() {
        return "sobre?faces-redirect=true";
    }

    public String onClickAcompanhamentoUsuario() {
        return "acompanhamentoUsuario?faces-redirect=true";
    }

    public String onClickMonitoramentoLotacao() {
        return "monitoramentoLotacao?faces-redirect=true";
    }

    public String onClickMonitoramentoServidor() {
        return "monitoramentoServidor?faces-redirect=true";
    }
}
