package facade;

import model.Servidor;

public interface ServidorFacade {
	public Servidor salvarServidor(Servidor servidor);

	public void excluirServidor(Servidor servidor);
}
