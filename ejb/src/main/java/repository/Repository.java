package repository;

import java.util.Collection;

import model.AbstractEntity;

public interface Repository<T extends AbstractEntity> {

	public T get(Number id);
	public T getReference(Number id);
	
	/* METODO DEVE SER UTILIZADO COM MUITO CUIDADO, POIS IRA CACHEAR TODAS AS CONSULTAS, CASO NAO DESEJE CACHEAR, UTILIZE O METODO getAll() */
	public Collection<T> getAllCacheable(String orderBy);
	public Collection<T> getAll(String orderBy);
	
	public Collection<T> getAllInRange(int start, int end);
	
}
