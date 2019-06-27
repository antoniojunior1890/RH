package repository.imp;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.OrgaoExpedidor;
import repository.OrgaoExpedidorRepository;

@Stateless
public class OrgaoExpedidorRepositoryImpl implements OrgaoExpedidorRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<OrgaoExpedidor> getOrgaosExpedidores() {
		UaiCriteria<OrgaoExpedidor> query = UaiCriteriaFactory.createQueryCriteria(manager, OrgaoExpedidor.class);
		query.orderByAsc("descricao");
        return query.getResultList();
	}

}
