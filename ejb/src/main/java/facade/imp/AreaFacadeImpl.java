package facade.imp;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AreaFacade;
import model.Area;
import util.GenericPersistence;

@Stateless
public class AreaFacadeImpl implements AreaFacade{
	
	@PersistenceContext
	private EntityManager manager;
	private GenericPersistence<Area, Number> persistence;

	@PostConstruct
	private void init() {
		persistence = new GenericPersistence<Area, Number>(Area.class, manager);
	}

	@Override
	public Area salvarArea(Area area) {
		return persistence.save(area);
	}

	@Override
	public void excluirArea(Area area) {
		persistence.remove(area);
	}

}
