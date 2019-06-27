package facade;

import model.Dependente;

public interface DependenteFacade {
	public Dependente salvarDependente(Dependente dependente);

	public void excluirDependente(Dependente dependente);
}
