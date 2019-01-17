package com.crossoverjie.basic;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class ReflectionTest {
    @Test
    public void getClassTest(){
        Random generator = new Random();
        Class c1 = generator.getClass();
        String name = c1.getName();


        Assert.assertEquals(name,"java.util.Random");
    }
}
