package repository;

import java.util.Collection;

import model.Servidor;
import model.ServidorLotacao;

public interface ServidorLotacaoRepository {
	public Collection<ServidorLotacao> getServidorLotacoesAtivo(Servidor servidor);
}
