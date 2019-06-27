package repository.imp;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.LotacaoReal;
import model.TipoLotacao;
import repository.LotacaoRealRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Stateless
public class LotacaoRealRepositoryImpl implements LotacaoRealRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<LotacaoReal> getLotacoes() {
		UaiCriteria<LotacaoReal> query = UaiCriteriaFactory.createQueryCriteria(manager, LotacaoReal.class);
		query.orderByAsc("nome");
		return query.getResultList();
	}

	@Override
	public Collection<LotacaoReal> getLotacoes(TipoLotacao tipoLotacao) {
		UaiCriteria<LotacaoReal> query = UaiCriteriaFactory.createQueryCriteria(manager, LotacaoReal.class);
		query.andEquals("tipoLotacao", tipoLotacao);
		query.orderByAsc("nome");
		return query.getResultList();
	}

	public List<LotacaoReal> getLotacoes(String nome, int first, int pageSize) {
		if(nome != null) {
			UaiCriteria<LotacaoReal> query = UaiCriteriaFactory.createQueryCriteria(manager, LotacaoReal.class);
			query.andStringLike("nome", "%" + nome.toUpperCase() + "%");
			query.orderByAsc("nome");
			return query.setFirstResult(first).setMaxResults(pageSize).getResultList();
		}
		return new ArrayList<LotacaoReal>();
	}

    public Number getLotacoesCount(String nome) {
        if(nome != null) {
            UaiCriteria<LotacaoReal> query = UaiCriteriaFactory.createQueryCriteria(manager, LotacaoReal.class);
            query.andStringLike("nome", "%" + nome.toUpperCase() + "%");
            return query.countRegularCriteria();
        }
        return 0;
    }

    @Override
    public List<LotacaoReal> getLotacoesMax(String nome, Integer max) {
        if(nome != null) {
            UaiCriteria<LotacaoReal> query = UaiCriteriaFactory.createQueryCriteria(manager, LotacaoReal.class);
            query.andStringLike("nome", "%" + nome.toUpperCase() + "%");
            query.setMaxResults(max);
            query.orderByAsc("nome");
            return query.getResultList();
        }
        return new ArrayList<LotacaoReal>();
    }

    @Override
	public LotacaoReal getLotacaoRealCompleta(LotacaoReal lotacaoReal) {
		UaiCriteria<LotacaoReal> query = UaiCriteriaFactory.createQueryCriteria(manager, LotacaoReal.class);
		query.leftJoinFetch("lotacoesFolha");
		query.andEquals("id", lotacaoReal.getId());
		return query.getSingleResult();
	}
}
