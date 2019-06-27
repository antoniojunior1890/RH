package repository.imp;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.Uf;
import repository.EstadoRepository;


@Stateless
public class EstadoRepositoryImpl implements EstadoRepository {
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<Uf> getEstados() {
		UaiCriteria<Uf> query = UaiCriteriaFactory.createQueryCriteria(manager, Uf.class);
		query.orderByAsc("nome");
		return query.getResultList();
	}

}
