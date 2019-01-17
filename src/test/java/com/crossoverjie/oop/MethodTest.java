package com.crossoverjie.oop;

import org.junit.Test;
import org.springframework.util.Assert;

public class MethodTest {
    @Test
    public void invokeMethodTest() {
        int i = 123;
        plusInt(i);
        System.out.println(i);

        Student student = new Student();
        student.setAge(20);
        plusAge(student);
        System.out.println(student.getAge());

        Assert.notNull(student, "不为空");
    }

    private void plusInt(int origin) {
        origin = origin + 1;
        System.out.println(origin);
    }

    private void plusAge(Student student) {
        student = new Student();
        student.setAge(21);
        System.out.println(student.getAge());
    }
}

class Student {
    private int age;

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
