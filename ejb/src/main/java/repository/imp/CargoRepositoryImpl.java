package repository.imp;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.Banco;
import model.Cargo;
import repository.CargoRepository;
import util.GenericPersistence;

@Stateless
public class CargoRepositoryImpl implements CargoRepository{

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<Cargo> getCargos() {
		UaiCriteria<Cargo> query = UaiCriteriaFactory.createQueryCriteria(manager, Cargo.class);
		query.orderByAsc("descricao");
		return query.getResultList();
	}

}
