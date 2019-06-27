package security;

import model.PerfilUsuario;
import model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import util.JSFUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Renan on 01/08/16.
 */
public class AppUserDetailService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        Usuario usuario = JSFUtil.getUsuarioRepository().getUsuario(cpf.replaceAll("[.-]", ""));
        UsuarioSistema usuarioSistema = null;
        if (usuario != null) {
            usuarioSistema = new UsuarioSistema(usuario, getPerfis(usuario));
        }
        return usuarioSistema;
    }

    private Collection<? extends GrantedAuthority> getPerfis(Usuario usuario) {
        List<SimpleGrantedAuthority> authorities = new ArrayList();
        for (PerfilUsuario perfilUsuario : usuario.getPerfisUsuario()) {
            authorities.add(new SimpleGrantedAuthority(perfilUsuario.getPerfil().getNome().toUpperCase()));
        }
        return authorities;
    }
}
