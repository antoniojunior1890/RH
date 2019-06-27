package repository.imp;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.Area;
import repository.AreaRepository;

@Stateless
public class AreaRepositoryImpl implements AreaRepository{

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<Area> getAreas() {
		UaiCriteria<Area> query = UaiCriteriaFactory.createQueryCriteria(manager, Area.class);
		query.orderByAsc("descricao");
		return query.getResultList();
	}

}
