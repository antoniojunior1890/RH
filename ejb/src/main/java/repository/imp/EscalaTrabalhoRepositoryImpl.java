package repository.imp;

/**
 * Created by Renan on 12/07/16.
 */

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.EscalaTrabalho;
import repository.EscalaTrabalhoRepository;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Stateless
public class EscalaTrabalhoRepositoryImpl implements EscalaTrabalhoRepository {

    @PersistenceContext
    private EntityManager manager;
    @Override
    public Collection<EscalaTrabalho> getEscalasTrabalho() {
        UaiCriteria<EscalaTrabalho> query = UaiCriteriaFactory.createQueryCriteria(manager, EscalaTrabalho.class);
        query.orderByAsc("descricao");
        return query.getResultList();

    }
}

