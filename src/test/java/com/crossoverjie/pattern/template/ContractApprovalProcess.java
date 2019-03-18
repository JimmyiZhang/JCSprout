package com.crossoverjie.pattern.template;

// 合同审批
public class ContractApprovalProcess extends ApprovalProcess {
    @Override
    protected void notice(String message) {
        System.out.println("通知市场主管");
    }
}
