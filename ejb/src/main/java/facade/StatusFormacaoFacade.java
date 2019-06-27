package facade;

import model.StatusFormacao;

public interface StatusFormacaoFacade {
	public StatusFormacao salvarStatusFormacao(StatusFormacao statusFormacao);

	public void excluirStatusFormacao(StatusFormacao statusFormacao);
}
