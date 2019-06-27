package repository;

import model.DadosBancarios;
import model.Pessoa;

import java.util.Collection;

/**
 * Created by Renan on 07/07/16.
 */
public interface DadosBancariosRepository {
    public Collection<DadosBancarios> getDadosBancarios();
    public Collection<DadosBancarios> getDadosBancarios(Pessoa pessoa);
}
