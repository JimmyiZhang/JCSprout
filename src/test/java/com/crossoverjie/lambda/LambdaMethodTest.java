package com.crossoverjie.lambda;

import org.junit.Test;
import org.springframework.util.Assert;

import java.util.Arrays;

public class LambdaMethodTest {
    @Test
    public void staticMethodTest() {
        LambdaStudent[] students = {
                new LambdaStudent("L", 40, 170),
                new LambdaStudent("S", 50, 150),
                new LambdaStudent("M", 60, 160),
        };
        // 方法引用
        // Class::staticMethod
        Arrays.sort(students, LambdaStudent::compareHeight);

        // 正常模式
        Arrays.stream(students).forEach(x -> System.out.println(x.toString()));
        Assert.isTrue(true, "循环输出");
    }

    @Test
    public void instanceMethodTest() {
        LambdaStudent[] students = {
                new LambdaStudent("L", 40, 170),
                new LambdaStudent("S", 50, 150),
                new LambdaStudent("M", 60, 160),
        };
        // 方法引用
        // Class::instanceMethod
        Arrays.sort(students, LambdaStudent::compareWeight);

        // 正常模式
        Arrays.stream(students).forEach(x -> System.out.println(x.toString()));
        Assert.isTrue(true, "循环输出");
    }
}
