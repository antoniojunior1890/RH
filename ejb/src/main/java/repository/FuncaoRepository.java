package repository;

import java.util.Collection;
import java.util.List;

import model.Funcao;
import model.LotacaoReal;

public interface FuncaoRepository {
	public Collection<Funcao> getFuncoes();
	public List<Funcao> getFuncoesMax(String nome, Integer max);
}
