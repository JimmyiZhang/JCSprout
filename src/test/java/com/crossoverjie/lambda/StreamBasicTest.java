package com.crossoverjie.lambda;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.util.Assert;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamBasicTest {
    private static LambdaStudent[] students = new LambdaStudent[5];

    @BeforeClass
    public static void init() {
        students[0] = new LambdaStudent("XL", 40, 170);
        students[1] = new LambdaStudent("L", 40, 150);
        students[2] = new LambdaStudent("S", 50, 155);
        students[3] = new LambdaStudent("M", 50, 140);
        students[4] = new LambdaStudent("SM", 60, 145);
    }

    // ====================中间操作=====================================
    // 筛选
    @Test
    public void filterTest() {
        // 过滤流
        // 包含当前流中所有满足断言条件的元素
        long count = Arrays.stream(students)
                .filter(p -> p.getWeight() > 50)
                .count();
        System.out.println(count);
        Assert.isTrue(count == 1, "filter测试");
    }

    // 切片
    @Test
    public void skipAndLimitTest() {
        List<LambdaStudent> result = Arrays.stream(students)
                .skip(1)
                .limit(1)
                .collect(Collectors.toList());

        result.forEach(a -> System.out.println(a.getName()));
        Assert.isTrue(result.size() == 1, "skip-limit测试");
    }

    // 映射
    @Test
    public void mapTest() {
        // 映射流
        // 应用于当前流中所有元素所产生的结果
        List<LambdaStudentMap> result = Arrays.stream(students)
                .map(a -> new LambdaStudentMap(a.getName()))
                .collect(Collectors.toList());

        result.forEach(a -> System.out.println(a.getName()));
        Assert.notNull(result, "map测试");
    }

    // 匹配
    @Test
    public void matchTest() {
        // anyMatch至少匹配一个
        boolean hasAny = Arrays.stream(students).anyMatch(p -> p.getWeight() == 40);
        System.out.println(hasAny);
        Assert.isTrue(hasAny, "anyMatch");

        // allMatch全部匹配
        boolean hasAll = Arrays.stream(students).allMatch(p -> p.getWeight() > 40);
        System.out.println(hasAll);
        Assert.isTrue(!hasAll, "allMatch");

        // noneMatch全部不匹配
        boolean hasNone = Arrays.stream(students).noneMatch(p -> p.getWeight() > 100);
        System.out.println(hasNone);
        Assert.isTrue(hasNone, "noneMatch");
    }

    // 查找
    @Test
    public void findTest() {
        // findFirst查找第一个，对顺序有要求
        LambdaStudent student = Arrays.stream(students)
                .filter(p -> p.getWeight() == 40)
                .findFirst()
                .get();
        System.out.println(student.getName());
        Assert.isTrue(student.getName().equals("XL"), "findFirst");

        // findAny查找任意一个，对顺序无要求（可并行）
    }

    // ====================终端操作=====================================
    // 收集为list
    @Test
    public void toListTest() {
        List<LambdaStudent> list = Arrays.stream(students).collect(Collectors.toList());
        int count = list.size();
        System.out.println(count);
        System.out.println(list.getClass().getName());
        Assert.isTrue(count == 5, "toList测试");
    }

    // 收集为map
    @Test
    public void toMapTest() {
        Map<String, LambdaStudent> result = Arrays.stream(students)
                .collect(Collectors.toMap(LambdaStudent::getName, Function.identity()));

        result.entrySet().forEach(m -> System.out.println(m.getKey()));
        Assert.isTrue(result.size() == 5, "toMap测试");

        // 扩展toSet, toCollection
    }

    // 收集为LinkedList
    @Test
    public void toCollectionTest(){
        List<LambdaStudent> list = Arrays.stream(students).collect(Collectors.toCollection(LinkedList::new));
        int count = list.size();
        System.out.println(count);
        System.out.println(list.getClass().getName());
        Assert.isTrue(count == 5, "toCollection测试");
    }

    // 计数
    @Test
    public void countingTest(){
        Long count = Arrays.stream(students).collect(Collectors.counting());
        System.out.println(count);
        Assert.isTrue(count == 5, "counting测试");
    }

    // 计数
    @Test
    public void summingTest(){
        IntSummaryStatistics count = Arrays.stream(students).collect(Collectors.summarizingInt(LambdaStudent::getWeight));
        System.out.println(count.getMin());
        Assert.isTrue(count.getMin() == 40, "summing");
    }

    // 分组收集
    @Test
    public void groupingTest() {
        LambdaStudent[] students = new LambdaStudent[5];
        students[0] = new LambdaStudent("L", 40, 170);
        students[1] = new LambdaStudent("L", 40, 150);
        students[2] = new LambdaStudent("S", 50, 155);
        students[3] = new LambdaStudent("M", 50, 140);
        students[4] = new LambdaStudent("M", 60, 145);

        Map<String, List<LambdaStudent>> result = Arrays.stream(students)
                .collect(Collectors.groupingBy(LambdaStudent::getName));

        result.entrySet().forEach(m -> System.out.println(m.getValue().size()));
        Assert.isTrue(result.size() == 3, "toMap测试");
        // 扩展partitioningBy
    }
}
