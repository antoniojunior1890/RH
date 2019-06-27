package facade.imp;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.DependenteFacade;
import model.Dependente;
import util.GenericPersistence;

@Stateless
public class DependenteFacadeImpl implements DependenteFacade {

	@PersistenceContext
	private EntityManager manager;
	private GenericPersistence<Dependente, Number> persistence;

	@PostConstruct
	private void init() {
		persistence = new GenericPersistence<Dependente, Number>(Dependente.class, manager);
	}

	@Override
	public Dependente salvarDependente(Dependente dependente) {
		return persistence.save(dependente);
	}

	@Override
	public void excluirDependente(Dependente dependente) {
		persistence.remove(dependente);
	}

}
