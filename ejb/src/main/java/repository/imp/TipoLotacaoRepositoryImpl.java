package repository.imp;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.TipoLotacao;
import repository.TipoLotacaoRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Stateless
public class TipoLotacaoRepositoryImpl implements TipoLotacaoRepository {
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<TipoLotacao> getTipoLotacoes() {
		UaiCriteria<TipoLotacao> query = UaiCriteriaFactory.createQueryCriteria(manager, TipoLotacao.class);
		query.orderByAsc("descricao");
		return query.getResultList();
	}

}