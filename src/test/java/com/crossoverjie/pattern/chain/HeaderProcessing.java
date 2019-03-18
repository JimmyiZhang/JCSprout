package com.crossoverjie.pattern.chain;

public class HeaderProcessing extends ProcessingChain<String> {
    @Override
    protected String handleWork(String input) {
        return "CarByCar Header"+input;
    }
}
