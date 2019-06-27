package repository.imp;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.Situacao;
import repository.SituacaoRepository;

@Stateless
public class SituacaoRepositoryImpl implements SituacaoRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<Situacao> getSituacoes() {
		UaiCriteria<Situacao> query = UaiCriteriaFactory.createQueryCriteria(manager, Situacao.class);
		query.orderByAsc("descricao");
		return query.getResultList();
	}

	@Override
	public Situacao getSituacao(String situacao){
		UaiCriteria<Situacao> query = UaiCriteriaFactory.createQueryCriteria(manager, Situacao.class);
		if (situacao != null) {
			Situacao situacao1 = new Situacao();
			query.andEquals("descricao", situacao);
			situacao1 = query.getSingleResult();
			return  situacao1;
		}
		return null;
	}

}
