package facade;

import model.ServidorLotacao;

public interface ServidorLotacaoFacade {
	public ServidorLotacao salvarServidorLotacao(ServidorLotacao servidorLotacao);
	public void excluirServidorLotacao(ServidorLotacao servidorLotacao);
}
