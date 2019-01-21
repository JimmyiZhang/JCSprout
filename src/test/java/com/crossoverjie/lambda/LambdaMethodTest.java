package com.crossoverjie.lambda;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaMethodTest {
    private static LambdaStudent[] students = new LambdaStudent[3];

    @BeforeClass
    public static void init() {
        students[0] = new LambdaStudent("L", 40, 170);
        students[1] = new LambdaStudent("S", 50, 150);
        students[2] = new LambdaStudent("M", 60, 160);
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

    @Test
    public void filterTest() {
        long count = Arrays.stream(students)
                .filter(p -> p.getWeight() > 50)
                .count();
        System.out.println(count);
        Assert.isTrue(count == 1, "filter测试");
    }

    @Test
    public void mapTest() {
        List<LambdaStudentMap> result = Arrays.stream(students)
                .map(a -> new LambdaStudentMap(a.getName()))
                .collect(Collectors.toList());

        result.forEach(a -> System.out.println(a.getName()));
        Assert.notNull(result,"map测试");
    }
}
