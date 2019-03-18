package com.crossoverjie.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class MessageSubject {
    List<MessageObserver> observers = new ArrayList<>();

    // 注册观察者
    public void register(MessageObserver observer){
        this.observers.add(observer);
    }

    // 通知观察者
    public void notice(WeiboMessage message){
        observers.forEach(o->o.notice(message));
    }
}
