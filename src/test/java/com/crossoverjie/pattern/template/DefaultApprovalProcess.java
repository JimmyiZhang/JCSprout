package com.crossoverjie.pattern.template;

import java.util.function.Consumer;

// 默认实现
public class DefaultApprovalProcess {
    public void approve(Consumer<String> notice) {
        // 处理流程
        System.out.println("ApprovalProcess：已审批");
        String message = "审批结果";
        // 通知流程
        notice.accept(message);
        System.out.println("ApprovalProcess：已通知");
    }
}
