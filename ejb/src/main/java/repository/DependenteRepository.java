package repository;

import java.util.Collection;

import model.Dependente;
import model.Servidor;

public interface DependenteRepository {
	public Collection<Dependente> getDependentes(Servidor servidor);
}
