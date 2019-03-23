package com.crossoverjie.basic;

import org.junit.Assert;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateTimeTest {

    @Test
    public void ClockTest() {
        // 获取系统默认时区
        Clock clock1 = Clock.systemDefaultZone();
        System.out.println("系统时间日期：" + clock1.instant());
        System.out.println("系统时间毫秒：" + clock1.millis());

        // 获取系统时钟，并转化为UTC时区的日期和时间
        Clock clock2 = Clock.systemUTC();
        System.out.println("UTC时间日期：" + clock2.instant());
        System.out.println("UTC时间毫秒：" + clock2.millis());

        Assert.assertTrue(clock1.millis() == clock2.millis());
    }

    @Test
    public void InstantTest() {
        Instant instant1 = Instant.now();
        System.out.println("Instant时间日期：" + instant1);
        long instantSecond = instant1.getEpochSecond();
        System.out.println("Instant时间秒数：" + instantSecond);

        LocalDateTime local1 = LocalDateTime.now();
        long localSecond = local1.toEpochSecond(ZoneOffset.of("+8"));
        System.out.println("local时间秒数：" + localSecond);

        Assert.assertTrue(localSecond <= instantSecond);
    }

    @Test
    public void ZoneIdTest() {
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        LocalTime now1 = LocalTime.now(zone1);

        ZoneId zone2 = ZoneId.of("Brazil/East");
        LocalTime now2 = LocalTime.now(zone2);
        System.out.println("时区：Europe/Berlin---" + now1);
        System.out.println("时区：Brazil/East-----" + now2);

        LocalDate date3 = LocalDate.of(2019, 3, 23);
        ZonedDateTime zdt3 = date3.atStartOfDay(zone2);
        System.out.println("atStartOfDay: " + zdt3);
        LocalDateTime date4 = LocalDateTime.of(2019, 3, 23, 22, 24, 23);
        ZonedDateTime zdt4 = date4.atZone(zone2);
        System.out.println("asZone      :"+zdt4);

        Assert.assertTrue(true);
    }

    @Test
    public void LocalToZoneTest() {
        LocalDateTime local = LocalDateTime.of(2018, Month.AUGUST, 8, 8, 8, 8);
        Instant instant = local
                .atZone(ZoneId.systemDefault())
                .toInstant();

        System.out.println(instant);
    }

    @Test
    public void DurationTest() {
        // 以秒或者纳秒衡量时间的长短
        final LocalDateTime from = LocalDateTime.of(2018, Month.AUGUST, 8, 8, 8, 8);
        final LocalDateTime to = LocalDateTime.of(2018, Month.AUGUST, 16, 16, 16, 16);
        final Duration duration = Duration.between(from, to);
        System.out.println("Duration in days : " + duration.toDays());
        System.out.println("Duration in hours: " + duration.toHours());

        Duration duration2 = Duration.between(Instant.ofEpochSecond(10), Instant.ofEpochSecond(20));
        System.out.println("Duration in seconds: " + duration2.getSeconds());

        Assert.assertTrue(duration.isZero() == false);
    }

    @Test
    public void PeriodTest() {
        // 以年月日衡量时间的长短
        Period p1 = Period.between(LocalDate.of(2019, 1, 22), LocalDate.of(2019, 3, 1));

        System.out.println("Period is days  :" + p1.getDays());
        System.out.println("Period is months:" + p1.getMonths());
        System.out.println("Period is years :" + p1.getYears());

        Assert.assertTrue(p1.getDays() > 0);
    }

    @Test
    public void LocalDateTimeTest() {
        LocalDateTime d1 = LocalDateTime.of(2018, 8, 8, 8, 8);
        System.out.println(d1);
        LocalDateTime d2 = LocalDateTime.parse("2018-08-08T08:08");
        System.out.println(d2);

        // 时间获取
        System.out.println("getYear      :" + d1.getYear());
        System.out.println("getMonth     :" + d1.getMonth());
        System.out.println("getMonth     :" + d1.getMonth().getValue());

        System.out.println("getDayOfYear :" + d1.getDayOfYear());
        System.out.println("getDayOfMonth:" + d1.getDayOfMonth());

        System.out.println("getDayOfWeek :" + d1.getDayOfWeek());
        System.out.println("getWeek      :" + d1.getDayOfWeek().getValue());

        System.out.println("getHour      :" + d1.getHour());
        System.out.println("getMinute    :" + d1.getMinute());
        System.out.println("getSecond    :" + d1.getSecond());

        LocalDateTime d3 = LocalDate.now().atTime(LocalTime.now());
        System.out.println("getDayOfWeek :" + d3.getDayOfWeek());
        System.out.println("getDayOfMonth:" + d3.getDayOfMonth());
        System.out.println("getDayOfYear :" + d3.getDayOfYear());

        System.out.println("EPOCH_DAY :" + d3.getLong(ChronoField.EPOCH_DAY));
        System.out.println("lengthOfMonth:" + d3.toLocalDate().lengthOfMonth());

        Assert.assertTrue(d1.equals(d2));
    }

    @Test
    public void LocalDateTimeAndInstantTest() {
        LocalDateTime now1 = LocalDateTime.of(2018, 8, 8, 8, 8, 8);
        Instant instant1 = now1.toInstant(ZoneOffset.of("+8"));
        long epoch1 = instant1.toEpochMilli();

        Calendar now2 = new GregorianCalendar(2018, 7, 8, 8, 8, 8);
        Instant instant2 = now2.toInstant();
        long time2 = now2.getTimeInMillis();
        long epoch2 = instant2.toEpochMilli();
        System.out.println("TimeInMillis: " + time2);
        System.out.println(" EpochMillis: " + epoch2);

        Instant instant3 = Instant.now();
        System.out.println("INSTANT_SECONDS: " + instant3.getLong(ChronoField.INSTANT_SECONDS));

        Assert.assertTrue(epoch1 == epoch2);
    }

    @Test
    public void TemporalAdjusterTest() {
        LocalDate date1 = LocalDate.of(2019, 3, 23);
        LocalDate date2 = date1.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));

        System.out.println(date2);

        // firstDayOfMonth
        // lastDayOfMonth
        // next/previous

        Assert.assertTrue(date2.getDayOfMonth() == 29);
    }

    @Test
    public void FormatterTest() {
        LocalDateTime now1 = LocalDateTime.of(2018, 8, 8, 8, 8, 8);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String target = "2018-08-08 08:08:08";

        String actual1 = format.format(now1);
        Assert.assertTrue(target.equals(actual1));

        LocalDateTime now2 = LocalDateTime.parse(target, format);
        String actual2 = now2.format(format);
        Assert.assertTrue(target.equals(actual2));
    }


}
