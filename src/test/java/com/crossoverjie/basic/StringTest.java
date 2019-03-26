package com.crossoverjie.basic;

import org.junit.Assert;
import org.junit.Test;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

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

    @Test
    public void StringFormatTest() {
        int source = 1234;
        String target = "+001234";
        // 注意+也包括在长度内
        String actual = String.format("%+07d", source);
        System.out.println(actual);
        Assert.assertTrue("字符串相等", target.equals(actual));

        float sourceF = 1234.567F;
        String targetF = "1,234.57";
        String actualF = String.format("%,.2f", sourceF);
        System.out.println(actualF);
        Assert.assertTrue("字符串相等", targetF.equals(actualF));
    }

    @Test
    public void StringSortTest() {
        String[] names = {"张健民(Z)", "刘幼石(L)", "王强(W)"};
        Arrays.sort(names);

        Arrays.stream(names).forEach(System.out::println);
        // 排序后的结果：刘幼石(L) 张健民(Z) 王强(W)

        Comparator cnComparator = Collator.getInstance(Locale.CHINA);
        Arrays.sort(names, cnComparator);
        Arrays.stream(names).forEach(System.out::println);
        // 排序后的结果：刘幼石(L) 王强(W) 张健民(Z)
        Assert.assertTrue("排序测试", names.length > 0);
    }
}
