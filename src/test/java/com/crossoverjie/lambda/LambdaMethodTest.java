package com.crossoverjie.lambda;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaMethodTest {
    private static LambdaStudent[] students = new LambdaStudent[5];

    @BeforeClass
    public static void init() {
        students[0] = new LambdaStudent("XL", 40, 170);
        students[1] = new LambdaStudent("L", 40, 150);
        students[2] = new LambdaStudent("S", 50, 155);
        students[3] = new LambdaStudent("M", 50, 140);
        students[4] = new LambdaStudent("SM", 60, 145);
    }

    @Test
    public void staticMethodTest() {
        // 方法引用
        // Class::staticMethod
        Arrays.sort(students, LambdaStudent::compareHeight);

        // 正常模式
        Arrays.stream(students).forEach(x -> System.out.println(x.toString()));
        Assert.isTrue(true, "循环输出");
    }

    @Test
    public void instanceMethodTest() {
        // 方法引用
        // Class::instanceMethod
        Arrays.sort(students, LambdaStudent::compareWeight);

        // 正常模式
        Arrays.stream(students).forEach(x -> System.out.println(x.toString()));
        Assert.isTrue(true, "方法引用");
    }

    @Test
    public void newMethodTest() {
        ArrayList<String> names = new ArrayList<>();
        names.add("A");
        names.add("B");
        names.add("C");

        LambdaStudent[] students = names.stream().map(LambdaStudent::new)
                .toArray(LambdaStudent[]::new);
        // Stream<LambdaStudent> stream = names.stream().map(LambdaStudent::new);

        Arrays.stream(students).forEach(x -> System.out.println(x.toString()));
        Assert.isTrue(true, "构造器引用");
    }
}
