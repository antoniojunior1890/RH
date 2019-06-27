package repository.imp;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.DadosBancarios;
import model.Pessoa;
import repository.DadosBancariosRepository;
import util.GenericPersistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

/**
 * Created by Renan on 07/07/16.
 */
@Stateless
public class DadosBancariosImpl implements DadosBancariosRepository {
    @PersistenceContext
    private EntityManager manager;
    private GenericPersistence<DadosBancarios, Number> persistence;

    @Override
    public Collection<DadosBancarios> getDadosBancarios() {
        UaiCriteria<DadosBancarios> query = UaiCriteriaFactory.createQueryCriteria(manager, DadosBancarios.class);
        query.orderByAsc("descricao");
        query.innerJoin("banco");
        query.orderByAsc("banco.descricao");
        return query.getResultList();
    }

    @Override
    public Collection<DadosBancarios> getDadosBancarios(Pessoa pessoa) {
        UaiCriteria<DadosBancarios> query = UaiCriteriaFactory.createQueryCriteria(manager, DadosBancarios.class);
        query.andEquals("pessoa", pessoa);
        query.innerJoin("banco");
        query.orderByAsc("banco.descricao");
        return query.getResultList();

    }
}
