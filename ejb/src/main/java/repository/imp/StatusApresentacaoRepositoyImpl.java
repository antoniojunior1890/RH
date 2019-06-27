package repository.imp;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.StatusApresentacao;
import repository.StatusApresentacaoRepository;
import util.GenericPersistence;

@Stateless
public class StatusApresentacaoRepositoyImpl implements StatusApresentacaoRepository {

	@PersistenceContext
	private EntityManager manager;

	private GenericPersistence<StatusApresentacao, Number> persistence;

	@PostConstruct
	private void init() {
		persistence = new GenericPersistence<StatusApresentacao, Number>(StatusApresentacao.class, manager);
	}
	
	@Override
	public Collection<StatusApresentacao> getStatusApresentacoes() {
		UaiCriteria<StatusApresentacao> query = UaiCriteriaFactory.createQueryCriteria(manager, StatusApresentacao.class);
		query.orderByAsc("descricao");
		return query.getResultList();
	}

}
