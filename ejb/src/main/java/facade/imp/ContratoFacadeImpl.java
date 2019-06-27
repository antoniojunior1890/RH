package facade.imp;

import facade.ContratoFacade;
import model.Contrato;
import util.GenericPersistence;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by antonio on 20/07/16.
 */
@Stateless
public class ContratoFacadeImpl implements ContratoFacade {

    @PersistenceContext
    private EntityManager manager;
    private GenericPersistence<Contrato, Number> persistence;

    @PostConstruct
    private void init() {
        persistence = new GenericPersistence<Contrato, Number>(Contrato.class, manager);
    }
    @Override
    public Contrato salvarContrato(Contrato contrato) {
        return persistence.save(contrato);
    }

    @Override
    public void excluirContrato(Contrato contrato) {
        persistence.remove(contrato);
    }
}
