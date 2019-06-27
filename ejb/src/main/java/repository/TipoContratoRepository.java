package repository;

import model.TipoContrato;

import java.util.Collection;

/**
 * Created by antonio on 20/07/16.
 */
public interface TipoContratoRepository {
    public Collection<TipoContrato> getTipoContratos();
}
