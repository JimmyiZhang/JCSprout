package com.crossoverjie.pattern.observer;

// 米粉
// 米发布微博通知他
public class RiceMessageObserver implements MessageObserver {
    @Override
    public void notice(WeiboMessage message) {
        if(message.getName().equals("RICE")){
            System.out.println("RICE收到消息, 非常高兴!");
        }
    }
}
