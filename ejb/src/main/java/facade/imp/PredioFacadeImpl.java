package facade.imp;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.PredioFacade;
import model.Predio;
import util.GenericPersistence;

@Stateless
public class PredioFacadeImpl implements PredioFacade {
	@PersistenceContext
	private EntityManager manager;
	private GenericPersistence<Predio, Number> persistence;

	@PostConstruct
	private void init() {
		persistence = new GenericPersistence<Predio, Number>(Predio.class, manager);
	}

	@Override
	public Predio salvarPredio(Predio predio) {
		return persistence.save(predio);
	}

	@Override
	public void excluirPredio(Predio predio) {
		persistence.remove(predio);
	}

}
