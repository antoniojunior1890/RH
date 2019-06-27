package facade.imp;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.ServidorLotacaoFacade;
import model.ServidorLotacao;
import util.GenericPersistence;

@Stateless
public class ServidorLotacaoFacadeImpl implements ServidorLotacaoFacade {

	@PersistenceContext
	private EntityManager manager;
	private GenericPersistence<ServidorLotacao, Number> persistence;

	@PostConstruct
	private void init() {
		persistence = new GenericPersistence<ServidorLotacao, Number>(ServidorLotacao.class, manager);
	}

	@Override
	public ServidorLotacao salvarServidorLotacao(ServidorLotacao servidorLotacao) {
		return persistence.save(servidorLotacao);
	}

	@Override
	public void excluirServidorLotacao(ServidorLotacao servidorLotacao) {
		persistence.remove(servidorLotacao);
	}

}
