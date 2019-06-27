package facade.imp;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.NivelFormacaoFacade;
import model.NivelFormacao;
import util.GenericPersistence;

@Stateless
public class NivelFormacaoFacadeImpl implements NivelFormacaoFacade {
	
	@PersistenceContext
	private EntityManager manager;
	private GenericPersistence<NivelFormacao, Number> persistence;

	@PostConstruct
	private void init() {
		persistence = new GenericPersistence<NivelFormacao, Number>(NivelFormacao.class, manager);
	}
	
	@Override
	public NivelFormacao salvarNivelFormacao(NivelFormacao nivelFormacao) {
		return persistence.save(nivelFormacao);
	}

	@Override
	public void excluirNivelFormacao(NivelFormacao nivelFormacao) {
		persistence.remove(nivelFormacao);
	}

}
