package com.crossoverjie.basic;

import org.junit.Assert;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
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
        System.out.println("Instant时间毫秒：" + instantSecond);

        // new SystemClock(ZoneId.systemDefault());
        Clock clock1 = Clock.systemDefaultZone();
        // instant().toEpochMilli();
        long clockSecond = clock1.millis() / 1000;
        System.out.println("Clock时间毫秒：" + clockSecond);

        LocalDateTime local1 = LocalDateTime.now();
        long localSecond = local1.getYear() * 365 * 24 * 60 * 60L;
        System.out.println("local时间毫秒：" + localSecond);

        Assert.assertTrue(clockSecond == instantSecond);
    }

    @Test
    public void ZoneIdTest() {
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        LocalTime now1 = LocalTime.now(zone1);

        ZoneId zone2 = ZoneId.of("Brazil/East");
        LocalTime now2 = LocalTime.now(zone2);
        System.out.println("时区：Europe/Berlin---" + now1);
        System.out.println("时区：Brazil/East-----" + now2);

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
        final LocalDateTime from = LocalDateTime.of(2018, Month.AUGUST, 8, 8, 8, 8);
        final LocalDateTime to = LocalDateTime.of(2018, Month.AUGUST, 16, 16, 16, 16);
        final Duration duration = Duration.between(from, to);
        System.out.println("Duration in days : " + duration.toDays());
        System.out.println("Duration in hours: " + duration.toHours());

        Assert.assertTrue(duration.isZero() == false);
    }

    @Test
    public void LocalTest() {
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

        Assert.assertTrue(d1.equals(d2));
    }

    @Test
    public void CreateTest() {
        LocalDateTime now1 = LocalDateTime.of(2018, 8, 8, 8, 8, 8);
        Instant instant1 = now1.toInstant(ZoneOffset.of("+8"));
        long epoch1 = instant1.toEpochMilli();

        Calendar now2 = new GregorianCalendar(2018, 7, 8, 8, 8, 8);
        Instant instant2 = now2.toInstant();
        long time2 = now2.getTimeInMillis();
        long epoch2 = instant2.toEpochMilli();


        Instant instant3 = Instant.now();
        System.out.println("TimeInMillis: " + time2);
        System.out.println(" EpochMillis: " + epoch2);

        Assert.assertTrue(epoch1 == epoch2);
    }

    @Test
    public void FormatterTest() {
        LocalDateTime now = LocalDateTime.of(2018, 8, 8, 8, 8, 8);
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String targetDT = "2018-08-08 08:08:08";
        String actualDT = format1.format(now);
        Assert.assertTrue(targetDT.equals(actualDT));
    }


}
