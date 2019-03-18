package com.crossoverjie.pattern.observer;

// 面粉
// 面粉发布微博通知他
public class FlourMessageObserver implements MessageObserver {
    @Override
    public void notice(WeiboMessage message) {
        if(message.getName().equals("FLOUR")){
            System.out.println("FLOUR收到消息, 非常高兴!");
        }
    }
}
