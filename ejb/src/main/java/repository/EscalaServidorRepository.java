package repository;

import model.EscalaServidor;
import model.Servidor;

import java.util.Collection;

public interface EscalaServidorRepository {
	public Collection<EscalaServidor>getEscalasServidor(Servidor servidor);
}
