package repository.imp;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.Simbologia;
import repository.SimbologiaRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

/**
 * Created by antonio on 19/07/16.
 */
@Stateless
public class SimbologiaRepositoryImpl implements SimbologiaRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public Collection<Simbologia> getSimbologias() {
        UaiCriteria<Simbologia> query = UaiCriteriaFactory.createQueryCriteria(manager, Simbologia.class);
        query.orderByAsc("sigla");
        return query.getResultList();
    }
}
