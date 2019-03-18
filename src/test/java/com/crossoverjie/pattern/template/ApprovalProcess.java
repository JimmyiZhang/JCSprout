package com.crossoverjie.pattern.template;

// 审批流程
public abstract class ApprovalProcess {
    // 审批
    public void approve(){
        // 处理流程
        System.out.println("ApprovalProcess：已审批");
        String message = "审批结果";
        // 通知流程
        notice(message);
        System.out.println("ApprovalProcess：已通知");
    }

    abstract protected void notice(String message);
}
