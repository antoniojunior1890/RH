package facade.imp;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.FuncaoFacade;
import model.Funcao;
import util.GenericPersistence;

@Stateless
public class FuncaoFacadeImpl implements FuncaoFacade {

	@PersistenceContext
	private EntityManager manager;
	private GenericPersistence<Funcao, Number> persistence;
	
	@PostConstruct
	private void init() {
		persistence = new GenericPersistence<Funcao, Number>(Funcao.class, manager);
	}
	
	@Override
	public Funcao salvarFuncao(Funcao funcao) {
		return persistence.save(funcao);
	}

	@Override
	public void excluirFuncao(Funcao funcao) {
		persistence.remove(funcao);
	}

}
