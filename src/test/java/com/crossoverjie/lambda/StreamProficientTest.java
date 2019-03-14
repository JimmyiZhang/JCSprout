package com.crossoverjie.lambda;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamProficientTest {
    private static LambdaStudent[] students = new LambdaStudent[5];

    @BeforeClass
    public static void init() {
        students[0] = new LambdaStudent("XL", 40, 170);
        students[1] = new LambdaStudent("L", 40, 150);
        students[2] = new LambdaStudent("S", 50, 155);
        students[3] = new LambdaStudent("M", 50, 140);
        students[4] = new LambdaStudent("SM", 60, 145);
    }

    // ===================规约============================
    // 归约求和
    @Test
    public void reduceSumTest() {
        int total = Arrays.stream(students)
                .map(LambdaStudent::getWeight)
                .reduce(0, (a, b) -> a + b);

        System.out.println(total);
        Assert.isTrue(total == 240, "reduce sum");
    }

    // 收集求和
    @Test
    public void collectSumTest() {
        int total = Arrays.stream(students)
                .collect(Collectors.reducing(
                        0,
                        LambdaStudent::getWeight,
                        Integer::sum));
        System.out.println(total);
        Assert.isTrue(total == 240, "collect sum");
    }

    // 基本类型流
    @Test
    public void intStreamTest() {
        int total = Arrays.stream(students)
                .mapToInt(LambdaStudent::getWeight)
                .sum();
        System.out.println(total);
        Assert.isTrue(total == 240, "mapToInt sum");
    }

    // 求最小值
    @Test
    public void reduceMinTest() {
        int min = Arrays.stream(students)
                .map(LambdaStudent::getWeight)
                .reduce((x, y) -> x > y ? y : x)
                .get();

        System.out.println(min);
        Assert.isTrue(min == 40, "reduce min");
    }
}
