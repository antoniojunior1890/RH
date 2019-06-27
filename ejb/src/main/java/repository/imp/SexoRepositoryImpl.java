package repository.imp;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.Sexo;
import repository.SexoRepository;

@Stateless
public class SexoRepositoryImpl implements SexoRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<Sexo> getSexos() {
		UaiCriteria<Sexo> query = UaiCriteriaFactory.createQueryCriteria(manager, Sexo.class);
		query.orderByAsc("descricao");
		return query.getResultList();
	}

}
