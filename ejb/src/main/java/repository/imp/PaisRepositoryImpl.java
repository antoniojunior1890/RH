package repository.imp;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.Pais;
import repository.PaisRepository;

@Stateless
public class PaisRepositoryImpl implements PaisRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<Pais> getPaises() {
		UaiCriteria<Pais> query = UaiCriteriaFactory.createQueryCriteria(manager, Pais.class);
		query.orderByAsc("nome");
		return query.getResultList();
	}

}
