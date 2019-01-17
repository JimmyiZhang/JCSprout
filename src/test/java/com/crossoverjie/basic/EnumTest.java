package com.crossoverjie.basic;

import org.junit.Assert;
import org.junit.Test;

public class EnumTest {
    enum Number {
        ONE,
        TWO,
        FIVE,
        TEN
    }

    @Test
    public void valuesTest() {
        Number[] numbers = Number.values();
        for (Number n : numbers) {
            System.out.println("第" + n.ordinal() + "个枚举，值是： " + numbers[n.ordinal()].name());
        }

        Assert.assertTrue(numbers.length == 4);
    }

    @Test
    public void valueOfTest() {
        Number one = Enum.valueOf(Number.class, "ONE");
        System.out.println(one.toString());

        Assert.assertTrue(one.equals(Number.ONE));
    }
}


