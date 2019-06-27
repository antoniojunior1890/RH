package facade.imp;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.ServidorFacade;
import model.Servidor;
import util.GenericPersistence;

@Stateless
public class ServidorFacadeImpl implements ServidorFacade {
	@PersistenceContext
	private EntityManager manager;
	private GenericPersistence<Servidor, Number> persistence;

	@PostConstruct
	private void init() {
		persistence = new GenericPersistence<Servidor, Number>(Servidor.class, manager);
	}

	@Override
	public Servidor salvarServidor(Servidor servidor) {
		return persistence.save(servidor);
	}

	@Override
	public void excluirServidor(Servidor servidor) {
		persistence.remove(servidor);
	}

}
