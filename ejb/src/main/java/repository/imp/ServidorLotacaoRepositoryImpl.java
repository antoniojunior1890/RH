package repository.imp;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.Servidor;
import model.ServidorLotacao;
import repository.ServidorLotacaoRepository;

@Stateless
public class ServidorLotacaoRepositoryImpl implements ServidorLotacaoRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Collection<ServidorLotacao> getServidorLotacoesAtivo(Servidor servidor) {
		UaiCriteria<ServidorLotacao> query = UaiCriteriaFactory.createQueryCriteria(manager, ServidorLotacao.class);
		query.andEquals("servidor", servidor);
		query.andEquals("ativa", 1);
		return query.getResultList();
	}

}
