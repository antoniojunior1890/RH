package facade;

import model.DadosBancarios;

/**
 * Created by Renan on 07/07/16.
 */
public interface DadosBancariosFacade {

    public DadosBancarios salvarDadosBancarios(DadosBancarios dadosBancarios);
    public void excluirDadosBancarios(DadosBancarios dadosBancarios);

}
