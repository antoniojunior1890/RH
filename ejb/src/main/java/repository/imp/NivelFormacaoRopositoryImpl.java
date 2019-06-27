package repository.imp;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.NivelFormacao;
import repository.NivelFormacaoRepository;

@Stateless
public class NivelFormacaoRopositoryImpl implements NivelFormacaoRepository{

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<NivelFormacao> getNivelFormacoes() {
		UaiCriteria<NivelFormacao> query = UaiCriteriaFactory.createQueryCriteria(manager, NivelFormacao.class);
		query.orderByAsc("descricao");
		return query.getResultList();
	}

}
