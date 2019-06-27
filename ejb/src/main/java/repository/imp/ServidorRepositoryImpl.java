package repository.imp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.*;
import repository.ServidorRepository;
import util.GenericPersistence;

@Stateless
public class ServidorRepositoryImpl implements ServidorRepository {

	@PersistenceContext
	private EntityManager manager;

	private GenericPersistence<Servidor, Number> persistence;

	@PostConstruct
	private void init() {
		persistence = new GenericPersistence<Servidor, Number>(Servidor.class, manager);
	}

	@Override
	public Collection<Servidor> getServidores() {
		UaiCriteria<Servidor> query = UaiCriteriaFactory.createQueryCriteria(manager, Servidor.class);
		query.innerJoin("pessoa");
		query.orderByAsc("pessoa.nome");
		return query.getResultList();
	}

	@Override
	public Servidor getServidoresFormacoes(Long id) {
		UaiCriteria<Servidor> query = UaiCriteriaFactory.createQueryCriteria(manager, Servidor.class);
		query.innerJoinFetch("pessoa");
		query.leftJoinFetch("pessoa.formacoes");
		query.andEquals("id", id);
		query.orderByAsc("pessoa.nome");
		return query.getResultList().get(0);
	}

	public Number getServidorCount(String matricula, String nome, String cpf, Cargo cargo, TipoVinculo tipoVinculo, LotacaoReal lotacaoReal, Funcao funcao, Situacao situacao, Boolean comLotacao) {
		UaiCriteria<Servidor> query = UaiCriteriaFactory.createQueryCriteria(manager, Servidor.class);
		query.innerJoin("pessoa");
        if(matricula != null){
            query.andEquals("matricula", matricula);
        }
		if(cpf != null){
			query.andEquals("pessoa.cpf", cpf);
		}
		if(cargo != null){
			query.innerJoin("cargo");
			query.andEquals("cargo.descricao", cargo.getDescricao().toUpperCase());
		}
		if(tipoVinculo != null){
			query.innerJoin("tipoVinculo");
			query.andEquals("tipoVinculo.descricao", tipoVinculo.getDescricao().toUpperCase());
		}
		if(lotacaoReal != null){
			query.innerJoin("servidorLotacoes.lotacaoReal");
			query.andEquals("servidorLotacoes.lotacaoReal.nome", lotacaoReal.getNome().toUpperCase());
		}
		if(funcao != null){
			query.innerJoin("funcao");
			query.andEquals("funcao.descricao", funcao.getDescricao().toUpperCase());
		}
		if(situacao != null){
			query.innerJoin("situacao");
			query.andEquals("situacao.descricao", situacao.getDescricao().toUpperCase());
		}
        if(nome != null){
            query.andStringLike("pessoa.nome", "%" + nome.toUpperCase() + "%");
        }
        if(comLotacao != null){
            if(comLotacao) {
                query.innerJoin("servidorLotacoes.lotacaoReal");
                query.andIsNotNull("servidorLotacoes.lotacaoReal");
            } else {
                query.andCollectionIsEmpty("servidorLotacoes");
            }
        }
		if(matricula == null && nome == null && cpf == null && cargo == null && tipoVinculo == null && lotacaoReal == null && funcao == null && situacao == null && comLotacao == null){
			return 0;
		}
		return query.countRegularCriteria();
	}

	@Override
	public List<Servidor> getServidor(String matricula, String nome, String cpf, Cargo cargo, TipoVinculo tipoVinculo, LotacaoReal lotacaoReal, Funcao funcao, Situacao situacao, Boolean comLotacao, int first, int pageSize) {
		UaiCriteria<Servidor> query = UaiCriteriaFactory.createQueryCriteria(manager, Servidor.class);
        query.innerJoin("pessoa");
        if(matricula != null){
            query.andEquals("matricula", matricula);
        }
		if(cpf != null){
			query.andEquals("pessoa.cpf", cpf);
		}
		if(cargo != null){
			query.innerJoin("cargo");
			query.andEquals("cargo.descricao", cargo.getDescricao().toUpperCase());
		}
		if(tipoVinculo != null){
			query.innerJoin("tipoVinculo");
			query.andEquals("tipoVinculo.descricao", tipoVinculo.getDescricao().toUpperCase());
		}
		if(lotacaoReal != null){
			query.innerJoin("servidorLotacoes.lotacaoReal");
			query.andEquals("servidorLotacoes.lotacaoReal.nome", lotacaoReal.getNome().toUpperCase());
		}
		if(funcao != null){
			query.innerJoin("funcao");
			query.andEquals("funcao.descricao", funcao.getDescricao().toUpperCase());
		}
		if(situacao != null){
			query.innerJoin("situacao");
			query.andEquals("situacao.descricao", situacao.getDescricao().toUpperCase());
		}
        if(nome != null){
            query.andStringLike("pessoa.nome", "%" + nome.toUpperCase() + "%");
        }
        if(comLotacao != null){
			if(comLotacao) {
                query.innerJoin("servidorLotacoes.lotacaoReal");
				query.andIsNotNull("servidorLotacoes.lotacaoReal");
			} else {
				query.andCollectionIsEmpty("servidorLotacoes");
			}
        }
		if(matricula == null && nome == null && cpf == null && cargo == null && tipoVinculo == null && lotacaoReal == null && funcao == null && situacao == null && comLotacao == null){
			return null;
		}
        query.orderByAsc("pessoa.nome");
		return query.setFirstResult(first).setMaxResults(pageSize).getResultList();
	}

	@Override
	public List<Servidor> getServidorMax(String nome, Integer max) {
		if(nome != null) {
			UaiCriteria<Servidor> query = UaiCriteriaFactory.createQueryCriteria(manager, Servidor.class);
			query.innerJoinFetch("pessoa");
			query.andStringLike("pessoa.nome", "%" + nome.toUpperCase() + "%");
			query.orderByAsc("pessoa.nome");
			return query.setMaxResults(max).getResultList();
		}
		return new ArrayList<Servidor>();
	}


	@Override
	public Servidor getServidorCompleto(Servidor servidor){
		if(servidor != null){
            UaiCriteria<Servidor> query = UaiCriteriaFactory.createQueryCriteria(manager, Servidor.class);
            query.leftJoinFetch("escalas");
            query.leftJoinFetch("dependentes");
            query.leftJoinFetch("pessoa.dadosBancarios");
            query.leftJoinFetch("pessoa.formacoes");
            query.andEquals("id",servidor.getId());
            return query.getSingleResult();
        }
        return null;
	}

}
