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
    public void ValuesTest() {
        Number[] numbers = Number.values();
        for (Number n : numbers) {
            System.out.println("第" + n.ordinal() + "个枚举，值是： " + numbers[n.ordinal()].name());
        }

        Assert.assertTrue(numbers.length == 4);
    }
}


