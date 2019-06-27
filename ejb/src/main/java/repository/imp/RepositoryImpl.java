package repository.imp;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.AbstractEntity;
import repository.Repository;

public class RepositoryImpl<T extends AbstractEntity> implements Repository<T> {

	private Class<T> type;
	private EntityManager manager;

	public RepositoryImpl(Class<T> type, EntityManager manager) {
		this.type = type;
		this.manager = manager;
	}

	@Override
	public Collection<T> getAll(String orderBy) {
		UaiCriteria<T> query = UaiCriteriaFactory.createQueryCriteria(
				manager, type);
		if (orderBy != null && !orderBy.isEmpty()) {
			query.orderByAsc(orderBy);
		}
		return query.getResultList();
	}

	@Override
	public T get(Number id) {
		return manager.find(type, id);
	}

	@Override
	public Collection<T> getAllInRange(int start, int max) {
		UaiCriteria<T> query = UaiCriteriaFactory.createQueryCriteria(
				manager, type);
		query.setFirstResult(start);
		query.setMaxResults(max);
		return query.getResultList();
	}

	@Override
	public T getReference(Number id) {
		return manager.getReference(type, id);
	}

	@Override
	public Collection<T> getAllCacheable(String orderBy) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(type);
		Root<T> root = query.from(type);
		query.select(root);
		if (orderBy != null && !orderBy.isEmpty()) {
			query.orderBy(builder.asc(root.get(orderBy)));
		}
		TypedQuery<T> typed = manager.createQuery(query);
//		typed.setHint("org.hibernate.cacheable", true); // DESBLOQUEAR SE FOR USAR CACHE
		return typed.getResultList();
	}

}
