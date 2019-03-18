package com.crossoverjie.pattern.chain;

// 责任链
// 一种创建对象序列的通用方案
public abstract class ProcessingChain<T> {
    protected ProcessingChain<T> successor;
    public void setSuccessor(ProcessingChain<T> successor) {
        this.successor = successor;
    }

    public T handle(T input) {
        T r = handleWork(input);
        if (successor != null) {
            return successor.handle(r);
        }
        return r;
    }

    abstract protected T handleWork(T input);
}
