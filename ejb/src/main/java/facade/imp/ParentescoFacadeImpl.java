package facade.imp;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.ParentescoFacade;
import model.Parentesco;
import util.GenericPersistence;

@Stateless
public class ParentescoFacadeImpl implements ParentescoFacade {

	@PersistenceContext
	private EntityManager manager;
	private GenericPersistence<Parentesco, Number> persistence;

	@PostConstruct
	private void init() {
		persistence = new GenericPersistence<Parentesco, Number>(Parentesco.class, manager);
	}

	@Override
	public Parentesco salvarParentesco(Parentesco parentesco) {
		return persistence.save(parentesco);
	}

	@Override
	public void excluirParentesco(Parentesco parentesco) {
		persistence.remove(parentesco);
	}

}
