package beans;

import facade.PredioFacade;
import model.Municipio;
import model.Predio;
import model.TipoPosse;
import model.Uf;
import repository.EstadoRepository;
import repository.MunicipioRepository;
import repository.PredioRepository;
import repository.TipoPosseRepository;
import util.JSFUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.util.Collection;

@ManagedBean(name = "predioVMB")
@ViewScoped
public class PredioBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @EJB
    private PredioFacade predioFacade;
    @EJB
    private PredioRepository predioRepository;
    @EJB
    private MunicipioRepository municipioRepository;
    @EJB
    private TipoPosseRepository tipoPosseRepository;
    @EJB
    private EstadoRepository estadoRepository;

    private Collection<Predio> predios;
    private Collection<Municipio> municipios;
    private Collection<TipoPosse> tipoPosses;
    private Predio predio;
    private Uf estadoSelecionado;
    private Collection<Uf> estados;

    @PostConstruct
    public void init() {
        if (predio == null) {
            predio = new Predio();
        }
        atualizarPredios();
        tipoPosses = tipoPosseRepository.getTipoPosses();
        estados = estadoRepository.getEstados();
    }

    public Predio getPredio() {
        return predio;
    }

    public void setPredio(Predio predio) {
        this.predio = predio;
    }

    public Collection<Predio> getPredios() {
        return predios;
    }

    public void setPredios(Collection<Predio> predios) {
        this.predios = predios;
    }

    public Collection<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(Collection<Municipio> municipios) {
        this.municipios = municipios;
    }

    public Collection<TipoPosse> getTipoPosses() {
        return tipoPosses;
    }

    public void setTipoPosses(Collection<TipoPosse> tipoPosses) {
        this.tipoPosses = tipoPosses;
    }

    public Uf getEstadoSelecionado() {
        return estadoSelecionado;
    }

    public void setEstadoSelecionado(Uf estadoSelecionado) {
        if (predio != null) {
            this.estadoSelecionado = predio.getMunicipio().getUf();
        }
        this.estadoSelecionado = estadoSelecionado;
    }

    public Collection<Uf> getEstados() {
        return estados;
    }

    public void setEstados(Collection<Uf> estados) {
        this.estados = estados;
    }

    public void salvar(ActionEvent actionEvent) {
        predioFacade.salvarPredio(predio);
        atualizarPredios();
        JSFUtil.addDefaultSucessMessage();
    }

    public void excluir(ActionEvent actionEvent) {
        predioFacade.excluirPredio(predio);
        predio = new Predio();
        atualizarPredios();
        JSFUtil.addDefaultSucessMessage();
    }

    public void novo(ActionEvent actionEvent) {
        predio = new Predio();
    }

    public void atualizarPredios() {
        predios = predioRepository.getPredios();

    }

    public void onSelectEstado(AjaxBehaviorEvent event) {
        municipios = municipioRepository.getMunicipios(estadoSelecionado);
    }

}
