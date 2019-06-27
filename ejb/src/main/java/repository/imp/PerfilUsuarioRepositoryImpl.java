package repository.imp;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.Perfil;
import repository.PerfilUsuarioRespository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Stateless
public class PerfilUsuarioRepositoryImpl implements PerfilUsuarioRespository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<Perfil> getPerfis() {
		UaiCriteria<Perfil> query = UaiCriteriaFactory.createQueryCriteria(manager, Perfil.class);
		query.orderByAsc("nome");
		return query.getResultList();
	}
}
