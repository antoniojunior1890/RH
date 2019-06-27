package facade;

import model.Parentesco;

public interface ParentescoFacade {
	public Parentesco salvarParentesco(Parentesco parentesco);

	public void excluirParentesco(Parentesco parentesco);
}
