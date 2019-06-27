package repository;

import java.util.Collection;

import model.Situacao;

public interface SituacaoRepository {
	public Collection<Situacao>getSituacoes();

	public Situacao getSituacao(String situacao);
}
