package be.ordina.workshop.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * @author Yannick De Turck
 */
public class NewDateTimeAPIExamples {
    public static void main(String[] args) {
        // Working with time zones
        Clock clock = Clock.systemDefaultZone(); // instead of System.currentTimeMillis()
        System.out.println("Time in millis: " + clock.millis());

        ZoneId zone = ZoneId.systemDefault();
        System.out.println("Zone: " + zone);
        ZoneId chihuahua = ZoneId.of("America/Chihuahua");
        Clock c = Clock.system(chihuahua);
        LocalTime timeChihuahua = LocalTime.now(c);
        System.out.println("Time in Chihuahua: " + timeChihuahua);

        long hoursBetween = ChronoUnit.HOURS.between(LocalTime.now(), LocalTime.of(17, 12, 33));
        System.out.println("Difference in hours: " + hoursBetween);

        DateTimeFormatter formatter = DateTimeFormatter
                .ofLocalizedTime(FormatStyle.SHORT)
                .withLocale(Locale.GERMAN);
        LocalTime parsedTime = LocalTime.parse("13:21", formatter);
        System.out.println("Parsed time: " + parsedTime);

        System.out.println("---");

        // Meet LocalDate
        LocalDate date = LocalDate.now();
        System.out.println("Year: " + date.getYear());
        System.out.println("Month: " + date.getMonthValue());
        System.out.println("Day: " + date.getDayOfMonth());

        formatter = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.MEDIUM)
                .withLocale(Locale.GERMAN);

        LocalDate parsedDate = LocalDate.parse("06.07.2014", formatter);
        System.out.println("Parsed date: " + parsedDate);

        System.out.println("---");

        // Instants are often used for timestamps and are easily convertible into the now legacy Date class
        Instant instant = LocalDateTime.now()
                .atZone(ZoneId.systemDefault())
                .toInstant();

        Date legacyDate = Date.from(instant);
        System.out.println("Legacy date: " + legacyDate);

        System.out.println("---");

        // Doing calculations with dates
        Period p = Period.ofWeeks(2);
        System.out.println("Now plus 2 weeks: " + date.plus(p)); // Alternative: date.plusWeeks(2);
        LocalTime now = LocalTime.now();
        LocalTime calculatedTime = now.plusMinutes(40);
        System.out.println("Now plus 40 mins: " + calculatedTime.toString());

        System.out.println("---");

        // Easily create dates
        date = LocalDate.of(2014, Month.MARCH, 24);
        System.out.println("Date: " + date);

        LocalTime time = LocalTime.of(16, 20, 31);
        System.out.println("Time: " + time);

        ZonedDateTime zonedTimeBrussels = ZonedDateTime.of(2014, 4, 1, 8, 30, 0, 0, ZoneId.systemDefault());
        ZonedDateTime zonedTime = zonedTimeBrussels.withZoneSameInstant(chihuahua);
        System.out.println("Datetime in Brussels: " + zonedTimeBrussels);
        System.out.println("Datetime in Chihuahua: " + zonedTime);

        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parsed = LocalDate.parse("01/06/2010", formatter);
        System.out.println("Parsed String: " + formatter.format(parsed));
    }
}
