package com.crossoverjie.pattern.strategy;

// 满减折扣
public class ReductionDiscountStrategy implements DiscountStrategy {
    // 满200减100
    @Override
    public int execute(int source) {
        if (source > 200) {
            return source - 100;
        }
        return source;
    }
}
