package converter;

import model.AbstractEntity;
import repository.Repository;
import repository.RepositoryFactory;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@FacesConverter(forClass = AbstractEntity.class, value = "conversor")
public class GenericConverter implements Converter {

    private Repository<? extends AbstractEntity> repositorio;
    private RepositoryFactory factory;

    public GenericConverter() throws NamingException {
        InitialContext contexto = new InitialContext();
        factory = (RepositoryFactory) contexto.lookup("java:global/rh-ear/rh-ejb/RepositoryFactoryImp!repository.RepositoryFactory");
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (value == null || value.isEmpty())
            return null;

        if (repositorio == null) {
            Class<? extends AbstractEntity> type = getTypeOfConverter(component);
            repositorio = factory.getRepository(type);
        }

        Object o = repositorio.get(Long.valueOf(value));

        return o;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
                              Object value) {

        if (!(value instanceof AbstractEntity))
            return "";

        AbstractEntity entity = (AbstractEntity) value;
        setTypeOfConverter(component, entity.getClass());

        return entity.getId().toString();
    }

    private void setTypeOfConverter(UIComponent ui, Class<?> type) {
        ui.getAttributes().put("type", type);
    }

    @SuppressWarnings("unchecked")
    private Class<? extends AbstractEntity> getTypeOfConverter(UIComponent ui) {
        return (Class<? extends AbstractEntity>) ui.getAttributes().get("type");

    }

}