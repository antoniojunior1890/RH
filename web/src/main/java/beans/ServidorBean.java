package beans;

import facade.*;
import model.*;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import repository.*;
import util.JSFUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.*;
import java.util.*;

@ManagedBean(name = "servidorVMB")
@ViewScoped
public class ServidorBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private ServidorFacade servidorFacade;
    @EJB
    private ServidorLotacaoFacade servidorLotacaoFacade;
    @EJB
    private FormacaoFacade formacaoFacade;
    @EJB
    private DependenteFacade dependenteFacade;
    @EJB
    private DocumentoFacade documentoFacade;
    @EJB
    private DadosBancariosFacade dadosBancariosFacade;
    @EJB
    private ServidorRepository servidorRepository;
    @EJB
    private OrgaoExpedidorRepository orgaoExpedidorRepository;
    @EJB
    private SexoRepository sexoRepository;
    @EJB
    private PaisRepository paisRepository;
    @EJB
    private AreaRepository areaRepository;
    @EJB
    private NivelFormacaoRepository nivelFormacaoRepository;
    @EJB
    private StatusFormacaoRepository statusFormacaoRepository;
    @EJB
    private ParentescoRepository parentescoRepository;
    @EJB
    private EstadoRepository estadoRepository;
    @EJB
    private MunicipioRepository municipioRepository;
    @EJB
    private OrgaoRepository orgaoRepository;
    @EJB
    private FuncaoRepository funcaoRepository;
    @EJB
    private CargoRepository cargoRepository;
    @EJB
    private TipoVinculoRepository tipoVinculoRepository;
    @EJB
    private SituacaoRepository situacaoRepository;
    @EJB
    private PredioRepository predioRepository;
    @EJB
    private StatusApresentacaoRepository statusApresentacaoRepository;
    @EJB
    private LotacaoFolhaRepository lotacaoRepository;
    @EJB
    private DependenteRepository dependenteRepository;
    @EJB
    private BancoRepository bancoRepository;
    @EJB
    private DadosBancariosRepository dadosBancariosRepository;
    @EJB
    private EscalaTrabalhoRepository escalaTrabalhoRepository;
    @EJB
    private FormacaoRepository formacaoRepository;
    @EJB
    private ServidorLotacaoRepository servidorLotacaoRepository;
    @EJB
    private TipoLotacaoRepository tipoLotacaoRepository;
    @EJB
    private LotacaoRealRepository lotacaoRealRepository;
    @EJB
    private SimbologiaRepository simbologiaRepository;
    @EJB
    private TipoContratoRepository tipoContratoRepository;
    @EJB
    private ContratoFacade contratoFacade;
    @EJB
    private DocumentoRepository documentoRepository;

    private Collection<Uf> estados;
    private Collection<Municipio> municipiosNascimento;
    private Collection<Municipio> municipiosEndereco;
    private Collection<OrgaoExpedidor> orgaosExpedidores;
    private Collection<Sexo> sexos;
    private Collection<Pais> paises;
    private Collection<Area> areas;
    private Collection<NivelFormacao> niveisFormacoes;
    private Collection<StatusFormacao> statusFormacoes;
    private Collection<Parentesco> parentescos;
    private Collection<Orgao> orgaos;
    private Collection<Funcao> funcoes;
    private Collection<Cargo> cargos;
    private Collection<TipoVinculo> tipoVinculos;
    private Collection<Situacao> situacoes;
    private Collection<Servidor> servidores;
    private Collection<Predio> predios;
    private Collection<StatusApresentacao> statusApresentacoes;
    private Collection<LotacaoFolha> lotacoes;
    private Collection<ServidorLotacao> servidorLotacoes;
    private Collection<Formacao> formacoes;
    private Collection<Documento> documentos;
    private Collection<EscalaTrabalho> escalasTrabalho;
    private Collection<Banco> bancos;
    private Collection<TipoLotacao> tipoLotacaos;
    private Collection<LotacaoReal> lotacoesReais;
    private Collection<Simbologia> simbologias;
    private Collection<TipoContrato> tipoContratos;
    private Collection<Contrato> contratos;

    private Uf estadoSelecionado;
    private Servidor servidor;
    private Dependente dependente;
    private DadosBancarios conta;
    private Formacao formacao;
    private Area areaSelelecionada;
    private Boolean flagCertificadoReservista;
    private String flagTabFormacao;
    private ServidorLotacao servidorLotacao;
    private UploadedFile arquivoUF;
    private Documento documento;
    private StreamedContent fileDown;
    private TipoLotacao tipoLotacaoSelecionada;
    private Boolean flagPeriodoVigencia;
    private Contrato contrato;

    @PostConstruct
    public void init() {
        servidor = (Servidor) JSFUtil.flashScope().get("servidor");
        if (servidor != null) {
            servidor = servidorRepository.getServidorCompleto(servidor);
            formacoes = new HashSet<Formacao>(formacaoRepository.getFormacoes(servidor.getPessoa()));
            servidorLotacoes = servidorLotacaoRepository.getServidorLotacoesAtivo(servidor);
            municipiosNascimento = municipioRepository.getMunicipios(servidor.getPessoa().getUfNascimento());
            municipiosEndereco = municipioRepository.getMunicipios(servidor.getPessoa().getUfEndereco());

        }
        if (servidor == null) {
            servidor = new Servidor();
        }
        if (formacao == null) {
            formacao = new Formacao();
        }
        if (dependente == null) {
            dependente = new Dependente();
        }
        if (servidorLotacao == null) {
            servidorLotacao = new ServidorLotacao();
        }
        if (conta == null) {
            conta = new DadosBancarios();
        }
        if (contrato == null) {
            contrato = new Contrato();
        }
        estados = estadoRepository.getEstados();
        orgaosExpedidores = orgaoExpedidorRepository.getOrgaosExpedidores();
        orgaos = orgaoRepository.getOrgaos();
        sexos = sexoRepository.getSexos();
        paises = paisRepository.getPaises();
        areas = areaRepository.getAreas();
        funcoes = funcaoRepository.getFuncoes();
        cargos = cargoRepository.getCargos();
        niveisFormacoes = nivelFormacaoRepository.getNivelFormacoes();
        statusFormacoes = statusFormacaoRepository.getStatusFormacoes();
        parentescos = parentescoRepository.getParentescos();
        tipoVinculos = tipoVinculoRepository.getTipoVinculos();
        situacoes = situacaoRepository.getSituacoes();
        bancos = bancoRepository.getBancos();
        flagCertificadoReservista = Boolean.FALSE;
        predios = predioRepository.getPredios();
        statusApresentacoes = statusApresentacaoRepository.getStatusApresentacoes();
        escalasTrabalho = escalaTrabalhoRepository.getEscalasTrabalho();
        tipoLotacaos = tipoLotacaoRepository.getTipoLotacoes();
        servidores = new ArrayList<Servidor>();
        simbologias = simbologiaRepository.getSimbologias();
        flagPeriodoVigencia = Boolean.FALSE;
        tipoContratos = tipoContratoRepository.getTipoContratos();
    }

    public Servidor getServidor() {
        if (servidor.getPessoa() == null) {
            servidor.setPessoa(new Pessoa());
        }
        return servidor;
    }

    public Collection<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(Collection<Contrato> contratos) {
        this.contratos = contratos;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Collection<TipoContrato> getTipoContratos() {
        return tipoContratos;
    }

    public void setTipoContratos(Collection<TipoContrato> tipoContratos) {
        this.tipoContratos = tipoContratos;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public Collection<Uf> getEstados() {
        return estados;
    }

    public void setEstados(Collection<Uf> estados) {
        this.estados = estados;
    }

    public Collection<Municipio> getMunicipiosNascimento() {
        return municipiosNascimento;
    }

    public void setMunicipiosNascimento(Collection<Municipio> municipiosNascimento) {
        this.municipiosNascimento = municipiosNascimento;
    }

    public Collection<OrgaoExpedidor> getOrgaosExpedidores() {
        return orgaosExpedidores;
    }

    public void setOrgaosExpedidores(Collection<OrgaoExpedidor> orgaosExpedidores) {
        this.orgaosExpedidores = orgaosExpedidores;
    }

    public Collection<Sexo> getSexos() {
        return sexos;
    }

    public void setSexos(Collection<Sexo> sexos) {
        this.sexos = sexos;
    }

    public Collection<Pais> getPaises() {
        return paises;
    }

    public void setPaises(Collection<Pais> paises) {
        this.paises = paises;
    }

    public Collection<Area> getAreas() {
        return areas;
    }

    public void setAreas(Collection<Area> areas) {
        this.areas = areas;
    }

    public Collection<Formacao> getFormacoes() {
        return formacoes;
    }

    public void setFormacoes(Collection<Formacao> formacoes) {
        this.formacoes = formacoes;
    }

    public Collection<NivelFormacao> getNiveisFormacoes() {
        return niveisFormacoes;
    }

    public void setNiveisFormacoes(Collection<NivelFormacao> niveisFormacoes) {
        this.niveisFormacoes = niveisFormacoes;
    }

    public Collection<StatusFormacao> getStatusFormacoes() {
        return statusFormacoes;
    }

    public void setStatusFormacoes(Collection<StatusFormacao> statusFormacoes) {
        this.statusFormacoes = statusFormacoes;
    }

    public Collection<Parentesco> getParentescos() {
        return parentescos;
    }

    public void setParentescos(Collection<Parentesco> parentescos) {
        this.parentescos = parentescos;
    }

    public Collection<Orgao> getOrgaos() {
        return orgaos;
    }

    public void setOrgaos(Collection<Orgao> orgaos) {
        this.orgaos = orgaos;
    }

    public Collection<Funcao> getFuncoes() {
        return funcoes;
    }

    public void setFuncoes(Collection<Funcao> funcoes) {
        this.funcoes = funcoes;
    }

    public Collection<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(Collection<Cargo> cargos) {
        this.cargos = cargos;
    }

    public Collection<TipoVinculo> getTipoVinculos() {
        return tipoVinculos;
    }

    public void setTipoVinculos(Collection<TipoVinculo> tipoVinculos) {
        this.tipoVinculos = tipoVinculos;
    }

    public Collection<Situacao> getSituacoes() {
        return situacoes;
    }

    public void setSituacoes(Collection<Situacao> situacoes) {
        this.situacoes = situacoes;
    }

    public Collection<Servidor> getServidores() {
        return servidores;
    }

    public void setServidores(Collection<Servidor> servidores) {
        this.servidores = servidores;
    }

    public Collection<Predio> getPredios() {
        return predios;
    }

    public void setPredios(Collection<Predio> predios) {
        this.predios = predios;
    }

    public Collection<StatusApresentacao> getStatusApresentacoes() {
        return statusApresentacoes;
    }

    public void setStatusApresentacoes(Collection<StatusApresentacao> statusApresentacoes) {
        this.statusApresentacoes = statusApresentacoes;
    }

    public Collection<LotacaoFolha> getLotacoes() {
        return lotacoes;
    }

    public void setLotacoes(Collection<LotacaoFolha> lotacoes) {
        this.lotacoes = lotacoes;
    }

    public Collection<ServidorLotacao> getServidorLotacoes() {
        return servidorLotacoes;
    }

    public void setServidorLotacoes(Collection<ServidorLotacao> servidorLotacoes) {
        this.servidorLotacoes = servidorLotacoes;
    }

    public Uf getEstadoSelecionado() {
        return estadoSelecionado;
    }

    public void setEstadoSelecionado(Uf estadoSelecionado) {
        this.estadoSelecionado = estadoSelecionado;
    }

    public Dependente getDependente() {
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }

    public Formacao getFormacao() {
        return formacao;
    }

    public void setFormacao(Formacao formacao) {
        this.formacao = formacao;
    }

    public Area getAreaSelelecionada() {
        return areaSelelecionada;
    }

    public void setAreaSelelecionada(Area areaSelelecionada) {
        this.areaSelelecionada = areaSelelecionada;
    }

    public Boolean getFlagCertificadoReservista() {
        return flagCertificadoReservista;
    }

    public void setFlagCertificadoReservista(Boolean flagCertificadoReservista) {
        this.flagCertificadoReservista = flagCertificadoReservista;
    }

    public String getFlagTabFormacao() {
        return flagTabFormacao;
    }

    public void setFlagTabFormacao(String flagTabFormacao) {
        this.flagTabFormacao = flagTabFormacao;
    }

    public ServidorLotacao getServidorLotacao() {
        return servidorLotacao;
    }

    public void setServidorLotacao(ServidorLotacao servidorLotacao) {
        this.servidorLotacao = servidorLotacao;
    }

    public DadosBancarios getConta() {
        return conta;
    }

    public void setConta(DadosBancarios conta) {
        this.conta = conta;
    }

    public Collection<Banco> getBancos() {
        return bancos;
    }

    public void setBancos(Collection<Banco> bancos) {
        this.bancos = bancos;
    }

    public StreamedContent getFileDown() throws FileNotFoundException {
        InputStream stream = new FileInputStream("/home/antonio/Área de Trabalho/teste/der.jpg");
        fileDown = new DefaultStreamedContent(stream, "image/jpg", "downloaded_optimus.jpg");
        return fileDown;
    }

    public void setFileDown(StreamedContent fileDown) {
        this.fileDown = fileDown;
    }

    public UploadedFile getFile() {
        return arquivoUF;
    }

    public void setFile(UploadedFile file) {
        this.arquivoUF = file;
    }

    public Documento getDocumento() {
        return documento;
    }

    public Collection<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Collection<Documento> documentos) {
        this.documentos = documentos;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Collection<Municipio> getMunicipiosEndereco() {
        return municipiosEndereco;
    }

    public void setMunicipiosEndereco(Collection<Municipio> municipiosEndereco) {
        this.municipiosEndereco = municipiosEndereco;
    }

    public Collection<EscalaTrabalho> getEscalasTrabalho() {
        return escalasTrabalho;
    }

    public void setEscalasTrabalho(Collection<EscalaTrabalho> escalasTrabalho) {
        this.escalasTrabalho = escalasTrabalho;
    }

    public Collection<TipoLotacao> getTipoLotacaos() {
        return tipoLotacaos;
    }

    public void setTipoLotacaos(Collection<TipoLotacao> tipoLotacaos) {
        this.tipoLotacaos = tipoLotacaos;
    }

    public Collection<LotacaoReal> getLotacoesReais() {
        return lotacoesReais;
    }

    public void setLotacoesReais(Collection<LotacaoReal> lotacoesReais) {
        this.lotacoesReais = lotacoesReais;
    }

    public TipoLotacao getTipoLotacaoSelecionada() {
        return tipoLotacaoSelecionada;
    }

    public void setTipoLotacaoSelecionada(TipoLotacao tipoLotacaoSelecionada) {
        this.tipoLotacaoSelecionada = tipoLotacaoSelecionada;
    }

    public Collection<Simbologia> getSimbologias() {
        return simbologias;
    }

    public void setSimbologias(Collection<Simbologia> simbologias) {
        this.simbologias = simbologias;
    }

    public Boolean getFlagPeriodoVigencia() {
        return flagPeriodoVigencia;
    }

    public void setFlagPeriodoVigencia(Boolean flagPeriodoVigencia) {
        this.flagPeriodoVigencia = flagPeriodoVigencia;
    }

    public Date getMaxDate() {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.YEAR, -18);
        return now.getTime();
    }

    public void salvar(ActionEvent actionEvent) {
        if (servidor.getSituacao() == null) {
            Situacao situacao = new Situacao();
            situacao.setId(Situacao.ID_PRE_CADASTRADO);
            servidor.setSituacao(situacao);
        }
        servidor = servidorFacade.salvarServidor(servidor);
        JSFUtil.addDefaultSucessMessage();
    }

    public void salvarConcluir(ActionEvent actionEvent) {
        servidor = servidorFacade.salvarServidor(servidor);
        servidor = new Servidor();
        JSFUtil.addDefaultSucessMessage();
    }

    public void inserirFuncao(ActionEvent actionEvent) {
        //EscalaServidor escalaServidor = servidor.getEscalaAtiva();
        //escalaServidor.setDataCadastro(new Date());
        //escalaServidor.setAtiva(1);
        //servidor.getEscalas().add(escalaServidor);
        if (contratos == null) {
            contratos = new LinkedHashSet<Contrato>();
        }
//        System.out.println("data : "+contrato.getDataInicio());
//        System.out.println("help : "+contrato.getVigencia());
        contratos.add(contratoFacade.salvarContrato(contrato));
        servidor.setContratos(contratos);
        servidor = servidorFacade.salvarServidor(servidor);
        servidorLotacao.setServidor(servidor);
        servidorLotacoes.add(servidorLotacaoFacade.salvarServidorLotacao(servidorLotacao));
        JSFUtil.addDefaultSucessMessage();
    }

    public void inserirFormacao(ActionEvent actionEvent) {
        if (formacoes == null) {
            formacoes = new LinkedHashSet<Formacao>();
        }
        formacao.setDocumentos(documentos);
        formacoes.add(formacaoFacade.salvarFormacao(formacao));
        servidor.getPessoa().setFormacoes(formacoes);
        servidor = servidorFacade.salvarServidor(servidor);
        formacao = new Formacao();
        JSFUtil.addDefaultSucessMessage();
    }

    public void inserirDependente(ActionEvent actionEvent) {
        if (servidor.getDependentes() == null) {
            servidor.setDependentes(new HashSet<Dependente>());
        }
        servidor.getDependentes().add(dependente);
        servidor = servidorFacade.salvarServidor(servidor);
        dependente = new Dependente();
        JSFUtil.addDefaultSucessMessage();
    }

    public void inserirConta(ActionEvent actionEvent) {
        if (servidor.getPessoa().getDadosBancarios() == null) {
            servidor.getPessoa().setDadosBancarios(new HashSet<DadosBancarios>());
        }
        conta.setPessoa(servidor.getPessoa());
        conta.setAtivo(1);
        servidor.getPessoa().getDadosBancarios().add(dadosBancariosFacade.salvarDadosBancarios(conta));
        servidor = servidorFacade.salvarServidor(servidor);
        conta = new DadosBancarios();
        JSFUtil.addDefaultSucessMessage();
    }

    public void excluir(ActionEvent actionEvent) {
        servidorFacade.excluirServidor(servidor);
        servidor = new Servidor();
        JSFUtil.addDefaultSucessMessage();
    }

    public void excluirFormacao(ActionEvent actionEvent) {
        formacoes.remove(formacao);
        formacaoFacade.excluirFormacao(formacao);
        servidor.getPessoa().setFormacoes(formacoes);
        formacao = new Formacao();
        JSFUtil.addDefaultSucessMessage();
    }

    public void excluirDependente(ActionEvent actionEvent) {
        servidor.getDependentes().remove(dependente);
        servidor = servidorFacade.salvarServidor(servidor);
        dependente = new Dependente();
        JSFUtil.addDefaultSucessMessage();
    }

    public void excluirConta(ActionEvent actionEvent) {
        servidor.getPessoa().getDadosBancarios().remove(conta);
        servidor = servidorFacade.salvarServidor(servidor);
        conta = new DadosBancarios();
        JSFUtil.addDefaultSucessMessage();
    }

    public void upload(FileUploadEvent event) {
        arquivoUF = event.getFile();
        if (arquivoUF != null) {
            if (documento == null) {
                documento = new Documento();
            }
            try {
                String caminho = FacesContext.getCurrentInstance().getExternalContext().getRealPath("");
                FileOutputStream arquivo = new FileOutputStream(new File(caminho, arquivoUF.getFileName()));
                arquivo.write(event.getFile().getContents());
                arquivo.close();
                //documento.setArquivo(caminho + "/" + event.getFile().getFileName());
                documento.setArquivo(event.getFile().getFileName());
                documento.setExtensao(event.getFile().getContentType());
                documento.setData(new Date());
                if (formacao.getId() != null) {
                    documentos = documentoRepository.getDocumentos(formacao);
                    System.out.println(documentos);
                }
                if (documentos == null) {
                    documentos = new ArrayList<Documento>();
                }
                documentos.add(documento);
                //System.out.println(documentos);
                documento = null;
                //formacao.setDocumentos(documentos);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void novo(ActionEvent actionEvent) {
        servidor = new Servidor();
    }

    public void novaFormacao(ActionEvent actionEvent) {
        formacao = new Formacao();
    }

    public void novoDependente(ActionEvent actionEvent) {
        dependente = new Dependente();
    }

    public void novaConta(ActionEvent actionEvent) {
        conta = new DadosBancarios();
    }

    public void download() throws FileNotFoundException {
        InputStream stream = new FileInputStream(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/teste") + "/der.jpg");    //"C:\\Users\\Antonio\\Desktop\\teste\\der.jpg");
        fileDown = new DefaultStreamedContent(stream, "image/jpg", "downloaded_optimus.jpg");
    }

    public void onSelectEstadoNascimento(AjaxBehaviorEvent event) {
        municipiosNascimento = municipioRepository.getMunicipios(servidor.getPessoa().getUfNascimento());
    }

    public void onSelectEstadoEndereco(AjaxBehaviorEvent event) {
        municipiosEndereco = municipioRepository.getMunicipios(servidor.getPessoa().getUfEndereco());
    }

    public void onSelectTipoLotacao(AjaxBehaviorEvent event) {
        if (servidorLotacao.getLotacaoReal() == null) {
            servidorLotacao.setLotacaoReal(new LotacaoReal());
        }
        servidorLotacao.getLotacaoReal().setTipoLotacao(tipoLotacaoSelecionada);
        lotacoesReais = lotacaoRealRepository.getLotacoes(servidorLotacao.getLotacaoReal().getTipoLotacao());
    }

    public void onSelectPeriodoVigencia(AjaxBehaviorEvent event) {
        if (servidor.getTipoVinculo() != null && servidor.getTipoVinculo().getId() == TipoVinculo.ID_CONTRATADO) {
            flagPeriodoVigencia = Boolean.TRUE;
            tipoContratos = tipoContratoRepository.getTipoContratos();
        } else {
            flagPeriodoVigencia = Boolean.FALSE;
        }
    }

    public void onSelectSexo(AjaxBehaviorEvent event) {
        if (servidor.getPessoa().getSexo().getId() == 1) {
            flagCertificadoReservista = Boolean.FALSE;
        } else {
            flagCertificadoReservista = Boolean.TRUE;
        }
    }
}
