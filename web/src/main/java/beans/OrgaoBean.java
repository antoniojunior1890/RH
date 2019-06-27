package beans;

import facade.OrgaoFacade;
import model.Orgao;
import repository.OrgaoRepository;
import util.JSFUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.Collection;

@ManagedBean(name = "orgaoVMB")
@ViewScoped
public class OrgaoBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @EJB
    private OrgaoFacade orgaoFacade;
    @EJB
    private OrgaoRepository orgaoRepository;
    private Collection<Orgao> orgaos;
    private Orgao orgao;

    @PostConstruct
    public void init() {
        if (orgao == null) {
            orgao = new Orgao();
        }
        atualizarOrgaos();
    }


    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }

    public Collection<Orgao> getOrgaos() {
        return orgaos;
    }

    public void setOrgaos(Collection<Orgao> orgaos) {
        this.orgaos = orgaos;
    }

    public void salvar(ActionEvent actionEvent) {
        orgaoFacade.salvarOrgao(orgao);
        atualizarOrgaos();
        JSFUtil.addDefaultSucessMessage();
    }

    public void excluir(ActionEvent actionEvent) {
        orgaoFacade.excluirOrgao(orgao);
        orgao = new Orgao();
        atualizarOrgaos();
        JSFUtil.addDefaultSucessMessage();
    }

    public void novo(ActionEvent actionEvent) {
        orgao = new Orgao();
    }

    public void atualizarOrgaos() {
        orgaos = orgaoRepository.getOrgaos();
    }


}
