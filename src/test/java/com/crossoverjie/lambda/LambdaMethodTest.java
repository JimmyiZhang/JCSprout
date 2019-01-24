package com.crossoverjie.lambda;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaMethodTest {
    private static LambdaStudent[] students = new LambdaStudent[5];

    @BeforeClass
    public static void init() {
        students[0] = new LambdaStudent("XL", 40, 170);
        students[1] = new LambdaStudent("L", 45, 150);
        students[2] = new LambdaStudent("S", 50, 155);
        students[3] = new LambdaStudent("M", 55, 140);
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

    @Test
    public void filterTest() {
        // 过滤流
        // 包含当前流中所有满足断言条件的元素
        long count = Arrays.stream(students)
                .filter(p -> p.getWeight() > 50)
                .count();
        System.out.println(count);
        Assert.isTrue(count == 2, "filter测试");
    }

    @Test
    public void mapTest() {
        // 映射流
        // 应用于当前流中所有元素所产生的结果
        List<LambdaStudentMap> result = Arrays.stream(students)
                .map(a -> new LambdaStudentMap(a.getName()))
                .collect(Collectors.toList());

        result.forEach(a -> System.out.println(a.getName()));
        Assert.notNull(result,"map测试");
    }

    @Test
    public void skipAndLimitTest(){
        List<LambdaStudent> result = Arrays.stream(students)
                .skip(1)
                .limit(1)
                .collect(Collectors.toList());

        result.forEach(a -> System.out.println(a.getName()));
        Assert.isTrue(result.size() == 1, "skip-limit测试");
    }
}
