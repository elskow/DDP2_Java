import DDP2.CSUI.utils.TimeMechanic;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TimeMechanicTests {
    @Test
    public void testGetThisDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String thisDate = formatter.format(LocalDate.now());
        assertEquals(thisDate, TimeMechanic.getThisDate());
    }

    @Test
    public void testIncrementDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String thisDate = formatter.format(LocalDate.now());
        LocalDate date = LocalDate.parse(thisDate, formatter);
        date = date.plusDays(1);
        thisDate = formatter.format(date);
        TimeMechanic.incrementDate();
        assertEquals(thisDate, TimeMechanic.getThisDate());
    }
}
