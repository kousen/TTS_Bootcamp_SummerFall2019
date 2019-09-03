package com.tts.hr;

import java.text.NumberFormat;

public class Salaried extends Employee {

    public static final double DEFAULT_SALARY = 104000.0;

    private double salary;

//    public Salaried() {
//        this("default name", DEFAULT_SALARY);
//    }

    public Salaried(String name) {
        this(name, DEFAULT_SALARY);
    }

    public Salaried(String name, double salary) {
        super(name);

      // super invoking the constructor in the parent
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double computePay() {
        return salary / 26.0;
    }

    @Override
    public String toString() {
        return super.toString() + ", salary = " +
                NumberFormat.getCurrencyInstance().format(salary);
    }
}
