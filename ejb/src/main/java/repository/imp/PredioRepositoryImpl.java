package repository.imp;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.Predio;
import repository.PredioRepository;

@Stateless
public class PredioRepositoryImpl implements PredioRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<Predio> getPredios() {
		UaiCriteria<Predio> query = UaiCriteriaFactory.createQueryCriteria(manager, Predio.class);
		query.orderByAsc("descricao");
		return query.getResultList();
	}

}
