package facade.imp;

import facade.PessoaFacade;
import facade.ServidorFacade;
import model.Pessoa;
import model.Servidor;
import util.GenericPersistence;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PessoaFacadeImpl implements PessoaFacade {
	@PersistenceContext
	private EntityManager manager;
	private GenericPersistence<Pessoa, Number> persistence;

	@PostConstruct
	private void init() {
		persistence = new GenericPersistence<Pessoa, Number>(Pessoa.class, manager);
	}


	@Override
	public Pessoa salvarPessoa(Pessoa pessoa) {
		return persistence.save(pessoa);
	}
}
