package facade;

import model.TipoLotacao;

/**
 * Created by antonio on 15/07/16.
 */
public interface TipoLotacaoFacade {
    public TipoLotacao salvarTipoLotacaoFacade(TipoLotacao tipoLotacao);

    public void excluirTipoLotacaoFacade(TipoLotacao tipoLotacao);
}
