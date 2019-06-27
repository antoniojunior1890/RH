package repository.imp;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.EscalaServidor;
import model.Servidor;
import repository.EscalaServidorRepository;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Stateless
public class EscalaServidorRepositoryImpl implements EscalaServidorRepository{

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<EscalaServidor> getEscalasServidor(Servidor servidor) {
        UaiCriteria<EscalaServidor> query = UaiCriteriaFactory.createQueryCriteria(manager, EscalaServidor.class);
        query.andEquals("servidor", servidor);
		return query.getResultList();

	}
}
