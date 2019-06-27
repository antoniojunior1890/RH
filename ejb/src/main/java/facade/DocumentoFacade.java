package facade;

import model.Documento;

public interface DocumentoFacade {
	public Documento salvarDocumento(Documento documento);

	public void excluirDocumento(Documento documento);
}
