package com.crossoverjie.pattern.chain;

public class FooterProcessing extends ProcessingChain<String> {
    @Override
    protected String handleWork(String input) {
        return "CarbyCar Footer" + input;
    }
}
