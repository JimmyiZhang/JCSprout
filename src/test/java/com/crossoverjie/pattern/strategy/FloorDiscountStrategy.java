package com.crossoverjie.pattern.strategy;

// 取整折扣
public class FloorDiscountStrategy implements DiscountStrategy {
    @Override
    public int execute(int source) {
        return source / 100 * 100;
    }
}
