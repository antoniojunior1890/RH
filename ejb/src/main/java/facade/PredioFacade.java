package facade;

import model.Predio;

public interface PredioFacade {
	public Predio salvarPredio(Predio predio);

	public void excluirPredio(Predio predio);
}
