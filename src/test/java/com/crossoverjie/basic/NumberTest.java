package com.crossoverjie.basic;

import org.junit.Assert;
import org.junit.Test;

public class NumberTest {
    @Test
    public void longTest() {
        long l1 = 123456;
        long l2 = 123 + 456;
        System.out.println(l1);
        System.out.println(l2);

        Assert.assertTrue(l1 > 0);
        Assert.assertTrue(l2 > 0);
    }

    @Test
    public void shortTest() {
        short s1 = 123;
        short s2 = 456;
        // 加法计算时s1,s2会提升为int，int+int=int,int转short会报错
        // short s3 = s1 + s2;

        Assert.assertTrue(s1<s2);
    }
}
