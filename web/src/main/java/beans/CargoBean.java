package beans;

import facade.CargoFacade;
import model.Cargo;
import repository.CargoRepository;
import util.JSFUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.util.Collection;

@ManagedBean(name = "cargoVMB")
@ViewScoped
public class CargoBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Integer ZERO = 0;
    @EJB
    private CargoFacade cargoFacade;
    @EJB
    private CargoRepository cargoRepository;
    private Collection<Cargo> cargos;
    private Cargo cargo;
    private Boolean flag;

    @PostConstruct
    public void init() {
        if (cargo == null) {
            cargo = new Cargo();
        }
        atualizarCargos();
        flag = Boolean.FALSE;
        cargo.setComissionado(ZERO);
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Collection<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(Collection<Cargo> cargos) {
        this.cargos = cargos;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public void salvar(ActionEvent actionEvent) {
        cargoFacade.salvarCargo(cargo);
        atualizarCargos();
        JSFUtil.addDefaultSucessMessage();
    }

    public void excluir(ActionEvent actionEvent) {
        cargoFacade.excluirCargo(cargo);
        cargo = new Cargo();
        atualizarCargos();
        JSFUtil.addDefaultSucessMessage();
    }

    public void novo(ActionEvent actionEvent) {
        cargo = new Cargo();
    }

    public void atualizarCargos() {
        cargos = cargoRepository.getCargos();
    }

    public void atualizar(AjaxBehaviorEvent event) {
        this.cargo.setComissionado(flag.equals(Boolean.TRUE) ? 1 : 0);
    }
}
