package com.crossoverjie.pattern.observer;

// 观察者模式
// 相应的作者发微博就会通知订阅者
public interface MessageObserver {
    void notice(WeiboMessage message);
}
