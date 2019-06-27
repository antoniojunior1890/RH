package beans;

import facade.AreaFacade;
import model.Area;
import repository.AreaRepository;
import util.JSFUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.Collection;

@ManagedBean(name = "areaVMB")
@ViewScoped
public class AreaBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @EJB
    private AreaFacade areaFacade;
    @EJB
    private AreaRepository areaRepository;
    private Collection<Area> areas;
    private Area area;

    @PostConstruct
    public void init() {
        if (area == null) {
            area = new Area();
        }
        atualizarArea();
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Collection<Area> getAreas() {
        return areas;
    }

    public void setAreas(Collection<Area> areas) {
        this.areas = areas;
    }

    public void salvar(ActionEvent actionEvent) {
        areaFacade.salvarArea(area);
        atualizarArea();
        JSFUtil.addDefaultSucessMessage();
    }

    public void excluir(ActionEvent actionEvent) {
        areaFacade.excluirArea(area);
        area = new Area();
        atualizarArea();
        JSFUtil.addDefaultSucessMessage();
    }

    public void novo(ActionEvent actionEvent) {
        area = new Area();
    }

    public void atualizarArea() {
        areas = areaRepository.getAreas();
    }
}
