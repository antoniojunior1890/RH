package facade.imp;

import facade.UsuarioFacade;
import model.Usuario;
import util.GenericPersistence;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Renan on 21/07/16.
 */
@Stateless
public class UsuarioFacadeImpl implements UsuarioFacade {

    @PersistenceContext
    private EntityManager manager;
    private GenericPersistence<Usuario, Number> persistence;

    @PostConstruct
    private void init() {
        persistence = new GenericPersistence<Usuario, Number>(Usuario.class, manager);
    }


    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        return persistence.save(usuario);
    }
}
