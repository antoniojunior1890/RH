package facade;

import model.Formacao;

public interface FormacaoFacade {
	public Formacao salvarFormacao(Formacao formacao);
	public void excluirFormacao(Formacao formacao);
}
