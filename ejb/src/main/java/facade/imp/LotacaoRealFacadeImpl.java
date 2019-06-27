package facade.imp;

import facade.LotacaoRealFacade;
import model.LotacaoReal;
import util.GenericPersistence;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LotacaoRealFacadeImpl implements LotacaoRealFacade {
	@PersistenceContext
	private EntityManager manager;
	private GenericPersistence<LotacaoReal, Number> persistence;

	@PostConstruct
	private void init() {
		persistence = new GenericPersistence<LotacaoReal, Number>(LotacaoReal.class, manager);
	}

	@Override
	public LotacaoReal salvarLotacaoReal(LotacaoReal lotacaoReal) {
		return persistence.save(lotacaoReal);
	}

	@Override
	public void excluirLotacaoReal(LotacaoReal lotacaoReal) {
		persistence.remove(lotacaoReal);
	}

}
