package repository.imp;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.StatusFormacao;
import repository.StatusFormacaoRepository;

@Stateless
public class StatusFormacaoRepositoryImpl implements StatusFormacaoRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<StatusFormacao> getStatusFormacoes() {
		UaiCriteria<StatusFormacao> query = UaiCriteriaFactory.createQueryCriteria(manager, StatusFormacao.class);
		query.orderByAsc("descricao");
		return query.getResultList();
	}
	

}
