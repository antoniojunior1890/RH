package facade.imp;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.StatusFormacaoFacade;
import model.StatusFormacao;
import util.GenericPersistence;

@Stateless
public class StatusFormacaoFacadeImpl implements StatusFormacaoFacade {

	@PersistenceContext
	private EntityManager manager;
	private GenericPersistence<StatusFormacao, Number> persistence;

	@PostConstruct
	private void init() {
		persistence = new GenericPersistence<StatusFormacao, Number>(StatusFormacao.class, manager);
	}

	@Override
	public StatusFormacao salvarStatusFormacao(StatusFormacao statusFormacao) {
		return persistence.save(statusFormacao);
	}

	@Override
	public void excluirStatusFormacao(StatusFormacao statusFormacao) {
		persistence.remove(statusFormacao);
	}
	

}
