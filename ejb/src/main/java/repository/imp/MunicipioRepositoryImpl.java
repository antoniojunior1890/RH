package repository.imp;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.Municipio;
import model.Uf;
import repository.MunicipioRepository;
import util.GenericPersistence;

@Stateless
public class MunicipioRepositoryImpl implements MunicipioRepository {
	@PersistenceContext
	private EntityManager manager;

	private GenericPersistence<Municipio, Number> persistence;

	@PostConstruct
	private void init() {
		persistence = new GenericPersistence<Municipio, Number>(Municipio.class, manager);
	}


	@Override
	public Collection<Municipio> getMunicipios() {
		return persistence.findAll();
	}

	@Override
	public Collection<Municipio> getMunicipios(Uf estado) {
		UaiCriteria<Municipio> query = UaiCriteriaFactory.createQueryCriteria(manager, Municipio.class);
		query.andEquals("uf", estado);
		query.orderByAsc("nome");
		return query.getResultList();
	}

}
