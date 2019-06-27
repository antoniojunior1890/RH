package repository.imp;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.Parentesco;
import repository.ParentescoRepository;

@Stateless
public class ParentescoRepositoryImpl implements ParentescoRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<Parentesco> getParentescos() {
		UaiCriteria<Parentesco> query = UaiCriteriaFactory.createQueryCriteria(manager, Parentesco.class);
		query.orderByAsc("descricao");
		return query.getResultList();
	}

}
