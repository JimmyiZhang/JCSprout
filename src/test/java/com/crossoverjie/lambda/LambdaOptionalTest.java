package com.crossoverjie.lambda;

import org.junit.Test;
import org.springframework.util.Assert;

import java.util.Optional;

public class LambdaOptionalTest {
    @Test
    public void optionalOrElseTest() {
        String str = null;
        String out = Optional.ofNullable(str).orElse("");

        Assert.isTrue(out.equals(""), "orElse默认值");
    }

    @Test
    public void optionalPresentTest() {
        String str = "good";
        Optional op = Optional.of(str);
        op.ifPresent(v -> System.out.println(v));

        Assert.isTrue(op.isPresent(), "empty optional");
    }

}
