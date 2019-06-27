package repository.imp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.Funcao;
import repository.FuncaoRepository;

@Stateless
public class FuncaoRepositoryImpl implements FuncaoRepository{
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Collection<Funcao> getFuncoes() {
		UaiCriteria<Funcao> query = UaiCriteriaFactory.createQueryCriteria(manager, Funcao.class);
		query.orderByAsc("descricao");
		return query.getResultList();
	}
	@Override
	public List<Funcao> getFuncoesMax(String nome, Integer max) {
		if(nome != null) {
			UaiCriteria<Funcao> query = UaiCriteriaFactory.createQueryCriteria(manager, Funcao.class);
			query.andStringLike("descricao", "%" + nome.toUpperCase() + "%");
			query.setMaxResults(max);
			query.orderByAsc("descricao");
			return query.getResultList();
		}
		return new ArrayList<Funcao>();
	}
}
