package com.crossoverjie.pattern.strategy;

// 策略模式
// 解决一类算法的通用解决方案
public interface DiscountStrategy {
    int execute(int source);
}
