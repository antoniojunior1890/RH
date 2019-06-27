package util;

import static javax.faces.context.FacesContext.getCurrentInstance;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.HttpServletResponse;

import model.AbstractEntity;
import repository.RepositoryFactory;
import repository.UsuarioRepository;

@ApplicationScoped
@ManagedBean(eager = true)
public class JSFUtil {

    @EJB
    private static RepositoryFactory factory;
    @EJB
    private static UsuarioRepository usuarioRepository;

    @PostConstruct
    private void init() {
        System.out.println("============== INICIANDO UTIL.. ===========");
    }

    public static OutputStream getReponseForPDF(String fileName) throws IOException {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) fc.getExternalContext().getResponse();
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        return response.getOutputStream();
    }

    public static void finalizarResposta() throws IOException {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) fc.getExternalContext().getResponse();
        OutputStream stream = response.getOutputStream();

        stream.flush();
        stream.close();

        fc.responseComplete();
    }

    public static void goToHome() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.getApplication().getNavigationHandler().handleNavigation(contexto, contexto.getViewRoot().getViewId(),
                "home");
    }

    public static void goTo(String action) {
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.getApplication().getNavigationHandler().handleNavigation(contexto, contexto.getViewRoot().getViewId(),
                action);
    }

    public static FacesContext getContext() {
        return FacesContext.getCurrentInstance();
    }

    public static Object getValueOfParam(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(key);
    }

    public static final boolean paramExists(String paramName) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().keySet()
                .contains(paramName);
    }

    public static final <T extends AbstractEntity> T getParamEntity(String paramName, Class<T> type) {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(paramName);

        if (id == null || id.isEmpty())
            return null;

        return factory.getRepository(type).get(Long.valueOf(id));
    }

    public static final <T extends AbstractEntity> T getParamEntity(String paramName, Class<T> type,
                                                                    boolean createIfNotExist) {
        try {
            AbstractEntity entity = getParamEntity(paramName, type);
            return (T) (entity != null ? entity : createIfNotExist ? type.newInstance() : null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final void addMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
    }

    public static final void addMessage(String message, Severity severidade) {
        FacesMessage fMessage = new FacesMessage(severidade, message, null);
        FacesContext.getCurrentInstance().addMessage(null, fMessage);
    }

    public static final void addDefaultSucessMessage() {
        addInfoMessage(getMessageFromI18N("lbl.msg.success"));
    }

    public static final void addDefaultErroMessage() {
        addErrorMessage(getMessageFromI18N("lbl.msg.error"));
    }

    private static String getMessageFromI18N(String key) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages_pt_BR",
                getCurrentInstance().getViewRoot().getLocale());
        return bundle.getString(key);
    }

    public static final void addInfoMessage(String message) {
        FacesMessage fMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, message, null);
        FacesContext.getCurrentInstance().addMessage(null, fMessage);
    }

    public static final void addWarnMessage(String message) {
        FacesMessage fMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, message, null);
        FacesContext.getCurrentInstance().addMessage(null, fMessage);
    }

    public static final void addErrorMessage(String message) {
        FacesMessage fMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null);
        FacesContext.getCurrentInstance().addMessage(null, fMessage);
    }

    public static Flash flashScope() {
        return (FacesContext.getCurrentInstance().getExternalContext().getFlash());
    }

    public static UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
}
