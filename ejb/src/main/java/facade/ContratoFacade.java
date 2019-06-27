package facade;

import model.Contrato;

/**
 * Created by antonio on 20/07/16.
 */
public interface ContratoFacade {
    public Contrato salvarContrato(Contrato contrato);

    public void excluirContrato(Contrato contrato);
}
