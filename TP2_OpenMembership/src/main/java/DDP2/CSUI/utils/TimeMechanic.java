package DDP2.CSUI.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeMechanic {
    protected static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    protected static String thisDate = formatter.format(LocalDate.now());

    public static String getThisDate() {
        return thisDate;
    }

    public static void incrementDate() {
        LocalDate date = LocalDate.parse(thisDate, formatter);
        date = date.plusDays(1);
        thisDate = formatter.format(date);
    }
}
