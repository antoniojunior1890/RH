package beans;

import facade.UsuarioFacade;
import model.Perfil;
import model.PerfilUsuario;
import model.Pessoa;
import model.Usuario;
import repository.PerfilUsuarioRespository;
import util.JSFUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by Renan on 27/07/16.
 */
@ManagedBean(name = "pessoaVMB")
@ViewScoped
public class PessoaBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private PerfilUsuarioRespository perfilUsuarioRespository;

    private Usuario usuario;
    private Collection<Perfil> perfis;
    private Perfil perfil;

    @PostConstruct
    public void init() {
        usuario = (Usuario) JSFUtil.flashScope().get("usuario");
        if (usuario == null) {
            usuario = new Usuario();
        } else {
            perfil = usuario.getPerfisUsuario().iterator().hasNext()  ? usuario.getPerfisUsuario().iterator().next().getPerfil() : null;
        }

        if (usuario.getPessoa() == null) {
            usuario.setPessoa(new Pessoa());
        }
        perfis = perfilUsuarioRespository.getPerfis();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Collection<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(Collection<Perfil> perfis) {
        this.perfis = perfis;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public void salvar(ActionEvent actionEvent) {
        usuario.setDataCadastro(new Date());
        usuario.setCpf(usuario.getPessoa().getCpf());
        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            usuario.setSenha(Usuario.senhaPadraoCriptografada);
        }
        usuario.setEmail(usuario.getPessoa().getEmail());
        if (usuario.getPerfisUsuario() == null || !usuario.getPerfisUsuario().iterator().hasNext()) {
            usuario.setPerfisUsuario(new HashSet<PerfilUsuario>());
            PerfilUsuario perfilUsuario = new PerfilUsuario();
            perfilUsuario.setPerfil(perfil);
            perfilUsuario.setDataHabilitacao(new Date());
            usuario.getPerfisUsuario().add(perfilUsuario);
        } else {
            usuario.getPerfisUsuario().iterator().next().setPerfil(perfil);
        }
        usuario = usuarioFacade.salvarUsuario(usuario);
        JSFUtil.addDefaultSucessMessage();
    }
}
