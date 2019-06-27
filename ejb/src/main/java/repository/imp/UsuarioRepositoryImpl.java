package repository.imp;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.Usuario;
import repository.UsuarioRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * Created by Renan on 21/07/16.
 */
@Stateless
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Usuario getUsuario(String cpf, String senha) {
        Usuario usuario;
        UaiCriteria<Usuario> query = UaiCriteriaFactory.createQueryCriteria(manager, Usuario.class);
        query.leftJoinFetch("perfisUsuario");
        query.andStringLike("cpf", cpf);
        query.andStringLike("senha", senha);
        try {
            usuario = query.getSingleResult();
        } catch (NoResultException ex) {
            usuario = null;
        } catch (RuntimeException ex) {
            usuario = null;
        } catch (Exception ex) {
            usuario = null;
        }
        return usuario;
    }

    @Override
    public Usuario getUsuario(String cpf) {
        Usuario usuario;
        UaiCriteria<Usuario> query = UaiCriteriaFactory.createQueryCriteria(manager, Usuario.class);
        query.leftJoinFetch("perfisUsuario");
        try {
            query.andEquals("cpf", cpf);
            usuario = query.getSingleResult();
        } catch (NoResultException ex) {
            usuario = null;
        } catch (RuntimeException ex) {
            usuario = null;
        } catch (Exception ex) {
            usuario = null;
        }
        return usuario;
    }
}
