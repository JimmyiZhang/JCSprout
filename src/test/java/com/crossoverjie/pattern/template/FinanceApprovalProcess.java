package com.crossoverjie.pattern.template;

// 财务审批
public class FinanceApprovalProcess extends ApprovalProcess {
    @Override
    protected void notice(String message) {
        System.out.println("通知财务主管");
    }
}
