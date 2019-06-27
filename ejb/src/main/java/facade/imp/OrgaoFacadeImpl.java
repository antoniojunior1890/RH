package facade.imp;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.OrgaoFacade;
import model.Orgao;
import util.GenericPersistence;

@Stateless
public class OrgaoFacadeImpl implements OrgaoFacade{
	@PersistenceContext
	private EntityManager manager;
	private GenericPersistence<Orgao, Number> persistence;

	@PostConstruct
	private void init() {
		persistence = new GenericPersistence<Orgao, Number>(Orgao.class, manager);
	}
	
	@Override
	public Orgao salvarOrgao(Orgao orgao) {
		return persistence.save(orgao);
	}

	@Override
	public void excluirOrgao(Orgao orgao) {
		persistence.remove(orgao);		
	}

}
