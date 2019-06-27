package repository.imp;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.Pais;
import model.TipoContrato;
import repository.TipoContratoRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

/**
 * Created by antonio on 20/07/16.
 */
@Stateless
public class TipoContratoRepositoryImpl implements TipoContratoRepository{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Collection<TipoContrato> getTipoContratos() {
        UaiCriteria<TipoContrato> query = UaiCriteriaFactory.createQueryCriteria(manager, TipoContrato.class);
        query.orderByAsc("descricao");
        return query.getResultList();
    }
}
