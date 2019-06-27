package repository.imp;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.LotacaoFolha;
import repository.LotacaoFolhaRepository;

@Stateless
public class LotacaoFolhaRepositoryImpl implements LotacaoFolhaRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<LotacaoFolha> getLotacoes() {
		UaiCriteria<LotacaoFolha> query = UaiCriteriaFactory.createQueryCriteria(manager, LotacaoFolha.class);
		query.orderByAsc("nome");
		return query.getResultList();
	}

    @Override
    public List<LotacaoFolha> getLotacoes(String nome) {
        if(nome != null) {
            UaiCriteria<LotacaoFolha> query = UaiCriteriaFactory.createQueryCriteria(manager, LotacaoFolha.class);
            query.andStringLike("nome", "%" + nome.toUpperCase() + "%");
            query.orderByAsc("nome");
            return query.getResultList();
        }
        return new ArrayList<LotacaoFolha>();
    }

    @Override
    public List<LotacaoFolha> getLotacoes(String nome, String orgao, Boolean vinculada, int first, int pageSize) {
        UaiCriteria<LotacaoFolha> query = UaiCriteriaFactory.createQueryCriteria(manager, LotacaoFolha.class);
        if(orgao != null) {
            query.innerJoin("orgao").andStringLike("orgao.descricao", "%"+orgao.toUpperCase()+"%");
        }
        if(vinculada != null){
            if(vinculada){
                query.andIsNotNull("lotacaoReal");
            } else {
                query.andIsNull("lotacaoReal");
            }
        }
        if(nome != null) {
            query.andStringLike("nome", "%" + nome.toUpperCase() + "%");
        }
        if(orgao == null && nome == null && vinculada == null){
            return new ArrayList<LotacaoFolha>();
        }
        query.orderByAsc("nome");
        return query.setFirstResult(first).setMaxResults(pageSize).getResultList();
    }

    @Override
    public Number getLotacoesCount(String nome, String orgao, Boolean vinculada) {
        UaiCriteria<LotacaoFolha> query = UaiCriteriaFactory.createQueryCriteria(manager, LotacaoFolha.class);
        if(orgao != null) {
            query.innerJoin("orgao").andStringLike("orgao.descricao", "%"+orgao.toUpperCase()+"%");
        }
        if(vinculada != null){
            if(vinculada){
                query.andIsNotNull("lotacaoReal");
            } else{
                query.andIsNull("lotacaoReal");
            }
        }
        if(nome != null) {
            query.andStringLike("nome", "%" + nome.toUpperCase() + "%");
        }
        if(orgao == null && nome == null && vinculada == null){
            return 0;
        }
        return query.countRegularCriteria();
    }
}
