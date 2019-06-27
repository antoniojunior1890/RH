package facade;

import model.LotacaoReal;

public interface LotacaoRealFacade {
	public LotacaoReal salvarLotacaoReal(LotacaoReal lotacaoReal);

	public void excluirLotacaoReal(LotacaoReal lotacaoReal);
}
