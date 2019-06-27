package repository;

import java.util.Collection;

import model.Municipio;
import model.Uf;

public interface MunicipioRepository {
	public Collection<Municipio> getMunicipios(Uf estado);

	public Collection<Municipio> getMunicipios();
}
