package facade;

import model.Situacao;

public interface SituacaoFacade {
	public Situacao salvarSituacao(Situacao situacao);

	public void excluirSituacao(Situacao situacao);
}
