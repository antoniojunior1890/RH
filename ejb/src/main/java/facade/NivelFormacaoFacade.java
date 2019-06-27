package facade;

import model.NivelFormacao;

public interface NivelFormacaoFacade {
	public NivelFormacao salvarNivelFormacao(NivelFormacao nivelFormacao);

	public void excluirNivelFormacao(NivelFormacao nivelFormacao);
}
