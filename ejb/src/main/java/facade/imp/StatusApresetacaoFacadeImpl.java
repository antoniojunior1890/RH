package facade.imp;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.StatusApresentacaoFacade;
import model.StatusApresentacao;
import util.GenericPersistence;

@Stateless
public class StatusApresetacaoFacadeImpl implements StatusApresentacaoFacade {

	@PersistenceContext
	private EntityManager manager;
	private GenericPersistence<StatusApresentacao, Number> persistence;

	@PostConstruct
	private void init() {
		persistence = new GenericPersistence<StatusApresentacao, Number>(StatusApresentacao.class, manager);
	}

	@Override
	public StatusApresentacao salvarStatusApresentacao(StatusApresentacao statusApresentacao) {
		return persistence.save(statusApresentacao);
	}

	@Override
	public void excluirStatusApresentacao(StatusApresentacao statusApresentacao) {
		persistence.remove(statusApresentacao);
	}

}
