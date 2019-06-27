package beans;

import model.LotacaoFolha;
import repository.LotacaoFolhaRepository;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Renan on 03/07/16.
 */
@ManagedBean(name = "diagramaVMB")
@ViewScoped
public class DiagramaBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB
    private LotacaoFolhaRepository lotacaoRepository;
    private Collection<LotacaoFolha> lotacoes;

    @PostConstruct
    public void init() {
        lotacoes = lotacaoRepository.getLotacoes();
    }

    public Collection<LotacaoFolha> getLotacoes() {
        return lotacoes;
    }

    public void setLotacoes(Collection<LotacaoFolha> lotacoes) {
        this.lotacoes = lotacoes;
    }
}
