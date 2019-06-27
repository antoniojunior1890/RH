package repository.imp;

import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.AbstractEntity;
import repository.Repository;
import repository.RepositoryFactory;

@Singleton
public class RepositoryFactoryImp implements RepositoryFactory {

	@PersistenceContext
	private EntityManager manager;

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public <T extends AbstractEntity> Repository<T> getRepository(Class<T> type) {
		return new RepositoryImpl<T>(type, manager);
	}

}
