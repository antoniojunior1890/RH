package repository;

import model.Contrato;
import model.Servidor;

import java.util.Collection;
import java.util.List;

/**
 * Created by antonio on 27/07/16.
 */
public interface ContratoRepository {
    public List<Contrato> getContratos(Servidor servidor);

    public Contrato getUltimoContrato(Servidor servidor);
}
