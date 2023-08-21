package cloud.academy.exprivia.springQuickstart.accessingdatajpa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtility {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static LocalDate getLocalDateFormString(String stringDate) {
        try {
            return LocalDate.parse(stringDate,formatter);
        } catch (DateTimeParseException e) {
            System.err.println("Errore durante il parsing della data: " + e.getMessage());
        }
        return LocalDate.now();
    }

    public static String getStringFromLocalDate(LocalDate localDate) {
        return localDate.format(formatter);
    }
}
