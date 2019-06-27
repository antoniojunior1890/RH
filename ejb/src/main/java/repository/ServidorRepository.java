package repository;

import java.util.Collection;
import java.util.List;

import model.*;

public interface ServidorRepository {
	public Collection<Servidor> getServidores();
	public List<Servidor> getServidor(String matricula, String nome, String cpf, Cargo cargo, TipoVinculo tipoVinculo, LotacaoReal lotacaoReal, Funcao funcao, Situacao situacao, Boolean comLotacao, int first, int pageSize);
    public Number getServidorCount(String matricula, String nome, String cpf, Cargo cargo, TipoVinculo tipoVinculo, LotacaoReal lotacaoReal, Funcao funcao, Situacao situacao, Boolean comLotacao);
	public Servidor getServidoresFormacoes(Long id);
	public Servidor getServidorCompleto(Servidor servidor);
	public List<Servidor> getServidorMax(String nome, Integer max);
}
