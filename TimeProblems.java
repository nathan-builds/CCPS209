package Lab29done;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeProblems {

    public static int countFridayThirteens(LocalDate start, LocalDate end) {

        int countOfFridays = 0;
        DayOfWeek friday = DayOfWeek.FRIDAY;

        while (!start.getDayOfWeek().equals(friday)) {
            start = start.plusDays(1);
        }
        while (start.isBefore(end)) {
            if (start.getDayOfWeek().equals(friday) && start.getDayOfMonth() == 13) { // if its a friday and the 13 add to count
                countOfFridays += 1;
            }
            start = start.plusDays(7); // next friday will be at +7 days
        }

        System.out.println("done");
        return countOfFridays;

    }

    public static String dayAfterSeconds(LocalDateTime timeHere, long seconds) {
        Duration d = Duration.ofSeconds(seconds);
        timeHere = timeHere.plus(d);
        return timeHere.getDayOfWeek().toString();
    }

    public static int whatHourIsItThere(LocalDateTime timeHere, String here, String there) {
       
        ZoneId hereID = ZoneId.of(here);
        ZoneId thereID = ZoneId.of(there);
        ZonedDateTime localTimeZone = timeHere.atZone(hereID);
        ZonedDateTime thereTimeZone = localTimeZone.withZoneSameInstant(thereID); // uses the locak time instant to get the time in a differnt time zone with a differnt zoneID
        System.out.println("done");
        return thereTimeZone.getHour();
    }
}
