package com.crossoverjie.lambda;

public class LambdaStudent {
    private String name;
    private int weight;
    private int height;

    public LambdaStudent(String name){
        this.name = name;
    }

    public LambdaStudent(String name, int weight, int height) {
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("name:%s, weight:%d, height:%d",
                this.name, this.weight, this.height);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int compareWeight(LambdaStudent student) {
        return this.weight - student.getWeight();
    }

    public static int compareHeight(LambdaStudent s1, LambdaStudent s2) {
        return s1.getHeight() - s2.getHeight();
    }

}
