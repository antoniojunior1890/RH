package util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.AbstractEntity;

/**
 * Classe resolve os métodos básicos de cadastro (CRUD) com API da
 * <code>JPA</code>.
 * 
 * @author Renan Costa
 */
public class GenericPersistence<T extends AbstractEntity, PK extends Number> {

	private Class<T> entityClass;
	private EntityManager manager;

	public GenericPersistence(Class<T> entityClass, EntityManager manager) {
		this.entityClass = entityClass;
		this.manager = manager;
	}

	public T save(T entity) {
		if (entity.getId() != null)
			return getEntityManager().merge(entity);
		else {
			getEntityManager().persist(entity);
			return entity;
		}
	}

	public void remove(T entity) {
		getEntityManager().remove(getEntityManager().merge(entity));
	}

	public T find(PK id) {
		return getEntityManager().find(entityClass, id);
	}

	public List<T> findAll() {
		CriteriaQuery cq = getEntityManager().getCriteriaBuilder()
				.createQuery();
		cq.select(cq.from(entityClass));
		return getEntityManager().createQuery(cq).getResultList();
	}

	public List<T> findRange(int first, int max) {
		CriteriaQuery cq = getEntityManager().getCriteriaBuilder()
				.createQuery();
		cq.select(cq.from(entityClass));
		Query q = getEntityManager().createQuery(cq);
		q.setMaxResults((max >= first) ? (max - first) : (first - max));
		q.setFirstResult(first);
		return q.getResultList();
	}

	public int count() {
		CriteriaQuery cq = getEntityManager().getCriteriaBuilder()
				.createQuery();
		Root<T> rt = cq.from(entityClass);
		cq.select(getEntityManager().getCriteriaBuilder().count(rt));
		Query q = getEntityManager().createQuery(cq);
		return ((Long) q.getSingleResult()).intValue();
	}

	/**
	 * Exige a definição do <code>EntityManager</code> responsável pelas
	 * operações de persistência.
	 */
	private EntityManager getEntityManager() {
		if (manager == null)
			throw new RuntimeException("O ENTITY MANAGER ESTA NULO");

		return manager;
	}

}
