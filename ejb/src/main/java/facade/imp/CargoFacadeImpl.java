package facade.imp;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.CargoFacade;
import model.Cargo;
import util.GenericPersistence;

@Stateless
public class CargoFacadeImpl implements CargoFacade{

	@PersistenceContext
	private EntityManager manager;
	private GenericPersistence<Cargo, Number> persistence;
	
	@PostConstruct
	private void init() {
		persistence = new GenericPersistence<Cargo, Number>(Cargo.class, manager);
	}
	@Override
	public Cargo salvarCargo(Cargo cargo) {
		return persistence.save(cargo);
	}

	@Override
	public void excluirCargo(Cargo cargo) {
		persistence.remove(cargo);
	}

}
