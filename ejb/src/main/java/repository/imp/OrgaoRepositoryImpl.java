package repository.imp;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.Orgao;
import repository.OrgaoRepository;

@Stateless
public class OrgaoRepositoryImpl implements OrgaoRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<Orgao> getOrgaos() {
		UaiCriteria<Orgao> query = UaiCriteriaFactory.createQueryCriteria(manager, Orgao.class);
		return query.getResultList();
	}

}
