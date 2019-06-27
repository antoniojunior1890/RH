package facade.imp;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.FormacaoFacade;
import model.Formacao;
import util.GenericPersistence;

@Stateless
public class FormacaoFacadeImpl implements FormacaoFacade{

	@PersistenceContext
	private EntityManager manager;
	private GenericPersistence<Formacao, Number> persistence;
	
	@PostConstruct
	private void init() {
		persistence = new GenericPersistence<Formacao, Number>(Formacao.class, manager);
	}
	
	
	@Override
	public Formacao salvarFormacao(Formacao formacao) {
		return persistence.save(formacao);
	}

	@Override
	public void excluirFormacao(Formacao formacao) {
		persistence.remove(formacao);		
	}

}
