package com.crossoverjie.lambda;

import org.junit.Test;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaComparatorTest {
    private LambdaStudent[] students = {
            new LambdaStudent("B", 40, 170),
            new LambdaStudent("B", 50, 150),
            new LambdaStudent("A", 60, 160),
    };

    @Test
    public void comparator1() {
        Arrays.sort(students, Comparator.comparing(LambdaStudent::getHeight));

        // 正常模式
        Arrays.stream(students).forEach(x -> System.out.println(x.toString()));
        Assert.isTrue(true, "循环输出");
    }

    @Test
    public void comparator2() {
        Arrays.sort(students,
                Comparator.comparing(LambdaStudent::getName)
                        .thenComparing(LambdaStudent::getWeight)
        );

        // 正常模式
        Arrays.stream(students).forEach(x -> System.out.println(x.toString()));
        Assert.isTrue(true, "循环输出");
    }
}
