package com.crossoverjie.basic;

import org.apache.commons.lang.time.FastDateFormat;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeTest {

    @Test
    public void FormatTest(){
        LocalDateTime now = LocalDateTime.of(2018,8,8,8,8,8);
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String targetDT = "2018-08-08 08:08:08";
        String actualDT = format1.format(now);
        Assert.assertTrue(targetDT.equals(actualDT));
    }
}
