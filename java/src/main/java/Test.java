import java.time.*;
import java.time.temporal.ChronoUnit;

public class Test {


    public static void main(String[] args) {

//        System.out.println("now : "+ LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
//        long oneYearAgo = LocalDate.now().minusYears(1).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
//        System.out.println(oneYearAgo);
//
//        oneYearAgo = LocalDate.now().minusYears(1).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
//        System.out.println(oneYearAgo);
//
//
//
//        long startOfTheDay = Instant.ofEpochMilli(oneYearAgo).atZone(ZoneId.systemDefault()).truncatedTo(ChronoUnit.DAYS).toInstant().toEpochMilli();
//        System.out.println(startOfTheDay);
//        long endOfTheDay = Instant.ofEpochMilli(startOfTheDay).atZone(ZoneId.systemDefault()).plus(1, ChronoUnit.DAYS).toInstant().toEpochMilli() - 1;
//        System.out.println(endOfTheDay);
////
//
//        System.out.println("zz "+LocalDate.now().minusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());

        //LocalDate.now().minusDays(1)..atStartOfDay(ZoneId.systemDefault())).truncatedTo(ChronoUnit.DAYS).toInstant().toEpochMilli();
//
//        1675695600000
//        1675695600000
//        1675781999999

//        Year year = Year.now();
//        System.out.println(year);
//
//        YearMonth yearMonth = YearMonth.now();
//        System.out.println(yearMonth);
//
//        LocalDate localDate = LocalDate.now();
//        System.out.println(localDate);
//
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(localDateTime);


        Long a = new Long(10L);

        Long b = a;
        b = 20L;

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a==b);
        System.out.println(a.hashCode()==b.hashCode());

        System.out.println(a);
        System.out.println(b);

    }
}
