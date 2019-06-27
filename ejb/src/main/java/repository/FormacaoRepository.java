package repository;

import java.util.Collection;

import model.Formacao;
import model.Pessoa;

public interface FormacaoRepository {
	public Collection<Formacao> getFormacoes(Pessoa pessoa);
}
