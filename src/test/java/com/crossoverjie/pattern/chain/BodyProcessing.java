package com.crossoverjie.pattern.chain;

public class BodyProcessing extends ProcessingChain<String> {
    @Override
    protected String handleWork(String input) {
        return "<body>" + input + "<body>";
    }
}
