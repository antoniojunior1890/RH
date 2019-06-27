package facade;

import model.Cargo;

public interface CargoFacade {
	public Cargo salvarCargo(Cargo cargo);
	public void excluirCargo(Cargo cargo);
}
