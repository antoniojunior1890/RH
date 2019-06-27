package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateControl {
    public static final String DATA_SEPARADO_POR_TRACO = "dd-MM-yyyy";

    public static String dateToPadrao(Date date) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        DateFormat dfH = new SimpleDateFormat("HH-mm");
        return (date == null ? "" : df.format(date) + "_" + dfH.format(date));
    }
}
