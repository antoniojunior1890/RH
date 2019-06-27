package repository.imp;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.Documento;
import model.Formacao;
import repository.DocumentoRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

/**
 * Created by antonio on 20/07/16.
 */
@Stateless
public class DocumentoRepositoryImpl implements DocumentoRepository{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Collection<Documento> getDocumentos(Formacao formacao) {
        UaiCriteria<Documento> query = UaiCriteriaFactory.createQueryCriteria(manager, Documento.class);
        query.andEquals("formacao", formacao);
        return query.getResultList();
    }
}
