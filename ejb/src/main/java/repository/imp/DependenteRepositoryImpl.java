package repository.imp;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.Dependente;
import model.Servidor;
import repository.DependenteRepository;

@Stateless
public class DependenteRepositoryImpl implements DependenteRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<Dependente> getDependentes(Servidor servidor) {
		UaiCriteria<Dependente> query = UaiCriteriaFactory.createQueryCriteria(manager, Dependente.class);
		query.andEquals("servidor", servidor);
		return query.getResultList();
	}


}
