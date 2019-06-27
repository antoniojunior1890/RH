package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "cpfConverter")
public class CpfConverter implements Converter {

    private Converter maskConverter = new ConverterMask();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
                              String value) {

        value = (String) maskConverter.getAsObject(context, component, value);

        if (value == null || value.isEmpty()) return null;

        while (value.length() < 11) {
            value = "0".concat(value);
        }

        return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value == null ? null : maskConverter.getAsString(context, component, value.toString());
    }

}
