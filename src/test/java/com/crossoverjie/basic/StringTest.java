package com.crossoverjie.basic;

import org.junit.Assert;
import org.junit.Test;


public class StringTest {
    @Test
    public void StringEqualsTest() {
        // 使用字面量声明则使用字符串变量池
        String a = "1234";
        String b = "1234";

        // 使用对象声明则不使用字符串变量池
        String c = new String("1234");
        Assert.assertTrue(a == b);
        Assert.assertFalse(a == c);
    }

    @Test
    public void StringInternTest() {
        String a = "1234";
        String b = new String("1234").intern();

        Assert.assertTrue("字符串相等", a == b);

    }


}
