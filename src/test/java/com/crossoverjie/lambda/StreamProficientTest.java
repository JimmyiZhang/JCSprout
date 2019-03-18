package com.crossoverjie.lambda;

import com.crossoverjie.pattern.observer.FlourMessageObserver;
import com.crossoverjie.pattern.observer.MessageSubject;
import com.crossoverjie.pattern.observer.RiceMessageObserver;
import com.crossoverjie.pattern.observer.WeiboMessage;
import com.crossoverjie.pattern.strategy.DiscountContext;
import com.crossoverjie.pattern.strategy.DiscountStrategyCategory;
import com.crossoverjie.pattern.strategy.PercentDiscountStrategy;
import com.crossoverjie.pattern.template.ApprovalProcess;
import com.crossoverjie.pattern.template.DefaultApprovalProcess;
import com.crossoverjie.pattern.template.FinanceApprovalProcess;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    // =============改善可读性和灵活性重构代码============
    // 改善代码的可读性，从匿名类到Lambda表达式到方法引用
    @Test
    public void refactor1() {
        // 自定义排序的实现
        // 匿名方式
        Arrays.sort(students, new Comparator<LambdaStudent>() {
            @Override
            public int compare(LambdaStudent o1, LambdaStudent o2) {
                return o1.getHeight() - o2.getHeight();
            }
        });

        // Lambda表达式
        Arrays.sort(students, (o1, o2) -> o1.getWeight() - o2.getWeight());

        // 方法引用
        Arrays.sort(students, Comparator.comparing(LambdaStudent::getName));
    }

    // 从命令式到Stream
    @Test
    public void refactor2() {
        // 获取宽度大于40的所有名称
        // 命令式
        List<String> names1 = new ArrayList<>();
        for (LambdaStudent student : students) {
            if (student.getWeight() > 40) {
                names1.add(student.getName());
            }
        }

        // Stream API
        List<String> names2 = Arrays.stream(students)
                .filter(s -> s.getWeight() > 40)
                .map(s -> s.getName())
                .collect(Collectors.toList());

        names2.forEach(System.out::println);
        Assert.isTrue(names1.size() == names2.size(), "Stream API改进");
    }

    // 增加代码的灵活性
    private String getLog() {
        return "log message";
    }

    @Test
    public void refactor3() {
        // 传统方式
        Logger logger = Logger.getLogger("refactor3");
        if (logger.isLoggable(Level.INFO)) {
            logger.info("Problem: " + getLog());
        }

        // 改进：不用判断
        // 问题：消息必须构造
        logger.log(Level.INFO, "Problem: " + getLog());

        // 延迟执行：不用判断，未开启日志，不构造消息
        logger.log(Level.INFO, () -> "Problem: " + getLog());
        // public void log(Level level, Supplier<String> msgSupplier){
        //     if(logger.isLoggable(level)){
        //         log(level, msgSupplier.get());
        //     }
        // }
    }

    // =============重构面向对象的设计模式============
    // 代替策略模式
    @Test
    public void refactor4() {
        // 打折策略
        DiscountContext context1 = new DiscountContext(new PercentDiscountStrategy());
        int target1 = context1.execute(199);
        System.out.println("target1=" + target1);

        DiscountContext context2 = new DiscountContext(DiscountStrategyCategory.REDUCTION);
        int target2 = context2.execute(199);
        System.out.println("target2=" + target2);

        DiscountContext context3 = new DiscountContext(d -> d / 100 * 100);
        int target3 = context3.execute(199);
        System.out.println("target3=" + target3);
        Assert.isTrue(target2 > target1, "Strategy test ");
    }

    // 代替模板模式
    @Test
    public void refactor5() {
        ApprovalProcess process = new FinanceApprovalProcess();
        process.approve();

        DefaultApprovalProcess process1 = new DefaultApprovalProcess();
        // 使用Lambda表达式代替一个通知
        process1.approve(s -> System.out.println("通知XX主管"));

        Assert.isTrue(true, "template pattern");
    }

    // 代替观察者模式
    @Test
    public void refactor6() {
        MessageSubject subject = new MessageSubject();
        // 使用register注册一个观察者
        subject.register(new RiceMessageObserver());
        subject.register(new FlourMessageObserver());

        // 使用Lambda表达式注册一个观察者
        subject.register(s->{
            if(s.getName().equals("RICE")){
                System.out.println("Lambda收到一个消息，哈哈哈");
            }
        });

        WeiboMessage message = new WeiboMessage();
        message.setName("RICE");
        message.setMessage("MESSAGE");
        subject.notice(message);

        Assert.isTrue(true, "observer pattern");
    }
}
