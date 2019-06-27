package repository;

import java.util.Collection;
import java.util.List;

import model.LotacaoFolha;

public interface LotacaoFolhaRepository {
	public List<LotacaoFolha> getLotacoes();
    public List<LotacaoFolha> getLotacoes(String nome);
	public List<LotacaoFolha> getLotacoes(String nome, String orgao, Boolean vinculada, int first, int pageSize);
	public Number getLotacoesCount(String nome, String orgao, Boolean vinculada);
}
