package facade.imp;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.SituacaoFacade;
import model.Situacao;
import util.GenericPersistence;

@Stateless
public class SituacaoFacadeImpl implements SituacaoFacade{
	@PersistenceContext
	private EntityManager manager;
	private GenericPersistence<Situacao, Number> persistence;

	@PostConstruct
	private void init() {
		persistence = new GenericPersistence<Situacao, Number>(Situacao.class, manager);
	}

	@Override
	public Situacao salvarSituacao(Situacao situacao) {
		return persistence.save(situacao);
	}

	@Override
	public void excluirSituacao(Situacao situacao) {
		persistence.remove(situacao);
	}

	
}
