package facade.imp;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.LotacaoFolhaFacade;
import model.LotacaoFolha;
import util.GenericPersistence;

@Stateless
public class LotacaoFolhaFacadeImpl implements LotacaoFolhaFacade {
	@PersistenceContext
	private EntityManager manager;
	private GenericPersistence<LotacaoFolha, Number> persistence;

	@PostConstruct
	private void init() {
		persistence = new GenericPersistence<LotacaoFolha, Number>(LotacaoFolha.class, manager);
	}

	@Override
	public LotacaoFolha salvarLotacao(LotacaoFolha lotacaoFolha) {
		return persistence.save(lotacaoFolha);
	}

	@Override
	public void excluirLotacao(LotacaoFolha lotacaoFolha) {
		persistence.remove(lotacaoFolha);
	}

}
