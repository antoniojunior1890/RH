package facade;

import model.LotacaoFolha;

public interface LotacaoFolhaFacade {
	public LotacaoFolha salvarLotacao(LotacaoFolha lotacaoFolha);

	public void excluirLotacao(LotacaoFolha lotacaoFolha);
}
