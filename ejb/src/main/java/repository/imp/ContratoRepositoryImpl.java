package repository.imp;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.Contrato;
import model.Servidor;
import repository.ContratoRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by antonio on 27/07/16.
 */
@Stateless
public class ContratoRepositoryImpl implements ContratoRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Contrato> getContratos(Servidor servidor) {
        UaiCriteria<Contrato> query = UaiCriteriaFactory.createQueryCriteria(manager, Contrato.class);
        query.andEquals("servidor",servidor);
        query.orderByDesc("dataInicio");
        return query.getResultList();
    }

    public Contrato getUltimoContrato(Servidor servidor) {
        UaiCriteria<Contrato> query = UaiCriteriaFactory.createQueryCriteria(manager, Contrato.class);
        query.andEquals("servidor",servidor);
        query.orderByDesc("dataInicio");
        return query.getSingleResult();
    }
}
