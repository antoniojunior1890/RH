package facade.imp;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.DocumentoFacade;
import model.Documento;
import util.GenericPersistence;

@Stateless
public class DocumentoFacadeImpl implements DocumentoFacade{
	
	@PersistenceContext
	private EntityManager manager;
	private GenericPersistence<Documento, Number> persistence;

	@PostConstruct
	private void init() {
		persistence = new GenericPersistence<Documento, Number>(Documento.class, manager);
	}
	
	@Override
	public Documento salvarDocumento(Documento documento) {
		return persistence.save(documento);
	}

	@Override
	public void excluirDocumento(Documento documento) {
		persistence.remove(documento);		
	}

}
