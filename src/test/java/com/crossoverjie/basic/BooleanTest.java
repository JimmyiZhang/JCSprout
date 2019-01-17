package com.crossoverjie.basic;

import org.junit.Test;
import org.springframework.util.Assert;

public class BooleanTest {

    @Test
    public void andAndTest() {
        boolean a = true;
        boolean b = true;
        boolean c = (a = (1 == 2)) && (b = (1 == 2));

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        Assert.isTrue(!a, "a的值是false");
        Assert.isTrue(b, "b的值是true");
        Assert.isTrue(!c, "c的值是false");
    }

    @Test
    public void andTest() {
        boolean a = true;
        boolean b = true;
        boolean c = (a = (1 == 2)) & (b = (1 == 2));

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        Assert.isTrue(!a, "a的值是false");
        Assert.isTrue(!b, "b的值是false");
        Assert.isTrue(!c, "c的值是false");
    }
}
