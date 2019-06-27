package repository.imp;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.TipoPosse;
import repository.TipoPosseRepository;
import util.GenericPersistence;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

/**
 * Created by antonio on 19/07/16.
 */
@Stateless
public class TipoPosseRepositoryImpl implements TipoPosseRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Collection<TipoPosse> getTipoPosses() {
        UaiCriteria<TipoPosse> query = UaiCriteriaFactory.createQueryCriteria(manager, TipoPosse.class);
        query.orderByAsc("descricao");
        return query.getResultList();
    }
}
