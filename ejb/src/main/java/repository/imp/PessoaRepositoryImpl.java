package repository.imp;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import model.*;
import repository.PessoaRepository;
import util.GenericPersistence;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class PessoaRepositoryImpl implements PessoaRepository {

	@PersistenceContext
	private EntityManager manager;

	private GenericPersistence<Pessoa, Number> persistence;

	@Override
	public Pessoa getPessoa(String cpf) {
        Pessoa pessoa;
        UaiCriteria<Pessoa> query = UaiCriteriaFactory.createQueryCriteria(manager, Pessoa.class);
        try {
            query.andEquals("cpf", cpf);
            pessoa = query.getSingleResult();
        } catch (NoResultException ex) {
            pessoa = null;
        } catch (RuntimeException ex) {
            pessoa = null;
        } catch (Exception ex) {
            pessoa = null;
        }
		return pessoa;
	}
}
