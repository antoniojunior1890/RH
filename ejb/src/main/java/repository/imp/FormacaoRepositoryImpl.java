package repository.imp;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.Formacao;
import model.Pessoa;
import repository.FormacaoRepository;

@Stateless
public class FormacaoRepositoryImpl implements FormacaoRepository {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Collection<Formacao> getFormacoes(Pessoa pessoa) {
		UaiCriteria<Formacao> query = UaiCriteriaFactory.createQueryCriteria(manager, Formacao.class);
		query.andEquals("pessoa", pessoa);
		return query.getResultList();
	}

}
