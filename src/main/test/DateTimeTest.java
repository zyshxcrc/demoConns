import java.time.*;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.TemporalAdjusters.*;

/**
 * Created by liuziyang on 2017/8/3.
 */
public class DateTimeTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date.getYear());
        LocalTime time = LocalTime.now();
        System.out.println(time.getHour());
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime.toString());
        LocalDateTime dateTime1 = LocalDateTime.of(2017,3,23,10,10,10);
        Duration duration = Duration.between(dateTime1,dateTime);
        Period period = Period.between(LocalDate.of(2017,3,3),LocalDate.of(2017,3,6));
        System.out.println(duration.toString());

        Duration duration1 = Duration.ofDays(2);
        Period period1 = Period.ofDays(2);
        System.out.println(period1.toString());

        LocalDateTime dateTime2 = dateTime.withYear(2016);
        System.out.println(dateTime2);

        LocalDateTime dateTime3 = dateTime.plusDays(1);
        System.out.println(dateTime3);
        System.out.println(dateTime.minusDays(1));

        System.out.println(dateTime.with(nextOrSame(DayOfWeek.SUNDAY)));
        System.out.println(dateTime.with(lastDayOfMonth()));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
        System.out.println(dateTime.format(formatter));

    }
}
