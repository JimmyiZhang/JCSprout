package com.crossoverjie.pattern.chain;

public class HeaderProcessing extends ProcessingChain<String> {
    @Override
    protected String handleWork(String input) {
        return "<header>carbycar<header>"+input;
    }
}
