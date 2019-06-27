package beans;

import facade.TipoVinculoFacade;
import model.TipoVinculo;
import repository.TipoVinculoRepository;
import util.JSFUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.Collection;

@ManagedBean(name = "tipoVinculoVMB")
@ViewScoped
public class TipoVinculoBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @EJB
    private TipoVinculoFacade tipoVinculoFacade;
    @EJB
    private TipoVinculoRepository tipoVinculoRepository;
    private Collection<TipoVinculo> tipoVinculos;
    private TipoVinculo tipoVinculo;

    @PostConstruct
    public void init() {
        if (tipoVinculo == null) {
            tipoVinculo = new TipoVinculo();
        }
        atualizartipoVinculo();
    }

    public TipoVinculo getTipoVinculo() {
        return tipoVinculo;
    }

    public void setTipoVinculo(TipoVinculo tipoVinculo) {
        this.tipoVinculo = tipoVinculo;
    }


    public Collection<TipoVinculo> getTipoVinculos() {
        return tipoVinculos;
    }

    public void setTipoVinculos(Collection<TipoVinculo> tipoVinculos) {
        this.tipoVinculos = tipoVinculos;
    }

    public void salvar(ActionEvent actionEvent) {
        tipoVinculoFacade.salvarTipoVinculoFacade(tipoVinculo);
        atualizartipoVinculo();
        JSFUtil.addDefaultSucessMessage();
    }

    public void excluir(ActionEvent actionEvent) {
        tipoVinculoFacade.excluirTipoVinculoFacade(tipoVinculo);
        tipoVinculo = new TipoVinculo();
        atualizartipoVinculo();
        JSFUtil.addDefaultSucessMessage();
    }

    public void novo(ActionEvent actionEvent) {
        tipoVinculo = new TipoVinculo();
    }

    private void atualizartipoVinculo() {
        tipoVinculos = tipoVinculoRepository.getTipoVinculos();
    }
}
