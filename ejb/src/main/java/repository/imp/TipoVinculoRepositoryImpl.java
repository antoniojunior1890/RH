package repository.imp;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.TipoVinculo;
import repository.TipoVinculoRepository;

@Stateless
public class TipoVinculoRepositoryImpl implements TipoVinculoRepository {
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<TipoVinculo> getTipoVinculos() {
		UaiCriteria<TipoVinculo> query = UaiCriteriaFactory.createQueryCriteria(manager, TipoVinculo.class);
		query.orderByAsc("descricao");
		return query.getResultList();
	}

}
