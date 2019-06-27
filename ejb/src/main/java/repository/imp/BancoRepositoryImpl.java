package repository.imp;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.Banco;
import repository.BancoRepository;
import util.GenericPersistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

/**
 * Created by Renan on 06/07/16.
 */
@Stateless
public class BancoRepositoryImpl implements BancoRepository {

    @PersistenceContext
    private EntityManager manager;

    private GenericPersistence<Banco, Number> persistence;

    @Override
    public Collection<Banco> getBancos() {
        UaiCriteria<Banco> query = UaiCriteriaFactory.createQueryCriteria(manager, Banco.class);
        query.orderByAsc("descricao");
        return query.getResultList();
    }
}
