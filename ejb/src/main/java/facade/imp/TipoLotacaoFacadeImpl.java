package facade.imp;

import facade.TipoLotacaoFacade;
import model.TipoLotacao;
import model.TipoVinculo;
import util.GenericPersistence;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by antonio on 15/07/16.
 */
@Stateless
public class TipoLotacaoFacadeImpl implements TipoLotacaoFacade{
    @PersistenceContext
    private EntityManager manager;
    private GenericPersistence<TipoLotacao, Number> persistence;

    @PostConstruct
    private void init() {
        persistence = new GenericPersistence<TipoLotacao, Number>(TipoLotacao.class, manager);
    }

    @Override
    public TipoLotacao salvarTipoLotacaoFacade(TipoLotacao tipoLotacao) {
        return persistence.save(tipoLotacao);
    }

    @Override
    public void excluirTipoLotacaoFacade(TipoLotacao tipoLotacao) {
        persistence.remove(tipoLotacao);
    }
}
