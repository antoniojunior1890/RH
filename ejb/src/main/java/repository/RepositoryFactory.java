package repository;

import model.AbstractEntity;

public interface RepositoryFactory {

	public <T extends AbstractEntity> Repository<T> getRepository(Class<T> type);

}
