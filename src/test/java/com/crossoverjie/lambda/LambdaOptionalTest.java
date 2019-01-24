package com.crossoverjie.lambda;

import org.junit.Test;
import org.springframework.util.Assert;

import java.util.Optional;

public class LambdaOptionalTest {
    @Test
    public void optionalTest() {
        String str = null;
        String out = Optional.ofNullable(str).orElse("");

        Assert.isTrue(out.equals(""), "orElse默认值");
    }
}
