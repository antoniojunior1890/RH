package converter;

import model.AbstractEntity;
import model.Servidor;
import repository.Repository;
import repository.RepositoryFactory;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by Renan on 15/07/16.
 */
@FacesConverter("servidorConverter")
public class ServidorConverter implements Converter {

    private Repository<? extends AbstractEntity> repositorio;
    private RepositoryFactory factory;

    public ServidorConverter() throws NamingException {
        InitialContext contexto = new InitialContext();
        factory = (RepositoryFactory) contexto.lookup("java:global/rh-ear/rh-ejb/RepositoryFactoryImp!repository.RepositoryFactory");
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        if (repositorio == null) {
            repositorio = factory.getRepository(Servidor.class);
        }
        Object o = repositorio.get(Long.valueOf(value));
        return o;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return String.valueOf(((Servidor) value).getId());
        } else {
            return null;
        }
    }
}
