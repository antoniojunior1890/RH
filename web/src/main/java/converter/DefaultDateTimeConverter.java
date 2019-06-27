package converter;

import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@FacesConverter(forClass = Date.class)
public class DefaultDateTimeConverter extends DateTimeConverter {

    public DefaultDateTimeConverter() {
        setPattern("dd/MM/yyyy");
        setLocale(new Locale("pt_BR"));
        setTimeZone(TimeZone.getTimeZone("GMT-3"));
    }

}
