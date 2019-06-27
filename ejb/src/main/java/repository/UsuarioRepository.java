package repository;

import model.Usuario;

/**
 * Created by Renan on 21/07/16.
 */
public interface UsuarioRepository {
    public Usuario getUsuario(String cpf, String senha);
    public Usuario getUsuario(String cpf);
}
