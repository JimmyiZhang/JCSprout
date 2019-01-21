package com.crossoverjie.lambda;

public class LambdaStudentMap {
    private String name;

    public LambdaStudentMap(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("name:%s", this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
