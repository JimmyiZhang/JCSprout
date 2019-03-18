package com.crossoverjie.pattern.strategy;

public class DiscountContext implements DiscountStrategy {
    DiscountStrategy strategy;

    // 原始方式
    public DiscountContext(DiscountStrategy strategy){
        this.strategy = strategy;
    }

    // 改进方式
    public DiscountContext(DiscountStrategyCategory category){
        switch (category){
            case  PERCENT:
                this.strategy = new PercentDiscountStrategy();
                break;
            case REDUCTION:
                this.strategy = new ReductionDiscountStrategy();
                break;
            case FLOOR:
                this.strategy = new FloorDiscountStrategy();
                break;
        }
    }

    @Override
    public int execute(int source) {
        return strategy.execute(source);
    }
}
