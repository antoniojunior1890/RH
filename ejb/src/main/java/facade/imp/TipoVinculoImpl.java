package facade.imp;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.TipoVinculoFacade;
import model.TipoVinculo;
import util.GenericPersistence;

@Stateless
public class TipoVinculoImpl implements TipoVinculoFacade {
	@PersistenceContext
	private EntityManager manager;
	private GenericPersistence<TipoVinculo, Number> persistence;

	@PostConstruct
	private void init() {
		persistence = new GenericPersistence<TipoVinculo, Number>(TipoVinculo.class, manager);
	}

	@Override
	public TipoVinculo salvarTipoVinculoFacade(TipoVinculo tipoVinculo) {
		return persistence.save(tipoVinculo);
	}

	@Override
	public void excluirTipoVinculoFacade(TipoVinculo tipoVinculo) {
		persistence.remove(tipoVinculo);		
	}

	

}
