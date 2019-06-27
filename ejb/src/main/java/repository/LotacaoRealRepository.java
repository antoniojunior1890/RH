package repository;

import model.LotacaoReal;
import model.TipoLotacao;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collection;
import java.util.List;

public interface LotacaoRealRepository {
	public Collection<LotacaoReal> getLotacoes();
	public Collection<LotacaoReal> getLotacoes(TipoLotacao tipoLotacao);
	public List<LotacaoReal> getLotacoes(String nome, int first, int pageSize);
	public Number getLotacoesCount(String nome);
	public List<LotacaoReal> getLotacoesMax(String nome, Integer max);
	public LotacaoReal getLotacaoRealCompleta(LotacaoReal lotacaoReal);
}
