package com.tts.hr;

public abstract class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double computePay();

    @Override
    public String toString() {
        return name;
    }
}
