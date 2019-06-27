package facade;

import model.StatusApresentacao;

public interface StatusApresentacaoFacade {
	public StatusApresentacao salvarStatusApresentacao(StatusApresentacao statusApresentacao);

	public void excluirStatusApresentacao(StatusApresentacao statusApresentacao);
}
