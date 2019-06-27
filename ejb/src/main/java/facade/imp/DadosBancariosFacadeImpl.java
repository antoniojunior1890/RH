package facade.imp;

import facade.DadosBancariosFacade;
import model.DadosBancarios;
import util.GenericPersistence;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Renan on 07/07/16.
 */
@Stateless
public class DadosBancariosFacadeImpl implements DadosBancariosFacade{

    @PersistenceContext
    private EntityManager manager;
    private GenericPersistence<DadosBancarios, Number> persistence;

    @PostConstruct
    private void init() {
        persistence = new GenericPersistence<DadosBancarios, Number>(DadosBancarios.class, manager);
    }

    @Override
    public DadosBancarios salvarDadosBancarios(DadosBancarios dadosBancarios) {
        return persistence.save(dadosBancarios);
    }

    @Override
    public void excluirDadosBancarios(DadosBancarios dadosBancarios) {
        persistence.remove(dadosBancarios);
    }
}
