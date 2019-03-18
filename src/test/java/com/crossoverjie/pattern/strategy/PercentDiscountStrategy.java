package com.crossoverjie.pattern.strategy;

// 比例折扣
public class PercentDiscountStrategy implements DiscountStrategy {

    @Override
    public int execute(int source) {
        // 5折
        return source * 5 / 10;
    }
}
