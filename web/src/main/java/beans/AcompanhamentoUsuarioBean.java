package beans;

import model.Pessoa;
import model.Usuario;
import repository.PessoaRepository;
import repository.UsuarioRepository;
import util.JSFUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Renan on 26/07/16.
 */
@ManagedBean(name = "acompanhamentoUsuarioVMB")
@ViewScoped
public class AcompanhamentoUsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private PessoaRepository pessoaRepository;
    @EJB
    private UsuarioRepository usuarioRepository;
    private Collection<Pessoa> pessoas;
    private Collection<Usuario> usuarios;
    private Usuario usuario;
    private String buscaCpf;
    private Boolean flagBotaoNovo;

    @PostConstruct
    public void init() {
        flagBotaoNovo = Boolean.FALSE;
        if (usuario == null) {
            usuario = new Usuario();
        }
        usuarios = new ArrayList<Usuario>();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Collection<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(Collection<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Collection<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Collection<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getBuscaCpf() {
        return buscaCpf;
    }

    public void setBuscaCpf(String buscaCpf) {
        this.buscaCpf = buscaCpf;
    }

    public Boolean getFlagBotaoNovo() {
        return flagBotaoNovo;
    }

    public void setFlagBotaoNovo(Boolean flagBotaoNovo) {
        this.flagBotaoNovo = flagBotaoNovo;
    }

    public void buscarUsuario(ActionEvent actionEvent) {
        flagBotaoNovo = Boolean.FALSE;
        usuarios = new ArrayList<Usuario>();
        usuario = usuarioRepository.getUsuario(buscaCpf);
        if (usuario != null) {
            usuarios.add(usuario);
        }
        if (buscaCpf != null && usuarios.isEmpty()) {
            flagBotaoNovo = Boolean.TRUE;
        }
    }

    public String onClickUsuario() {
        JSFUtil.flashScope().put("usuario", usuario);
        return "usuario?faces-redirect=true";
    }
}
