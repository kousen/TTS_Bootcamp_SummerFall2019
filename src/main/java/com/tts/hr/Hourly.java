package com.tts.hr;

public class Hourly extends Employee {
    public static final double DEFAULT_HOURS = 80.0;

    private double rate;
    private double hours = DEFAULT_HOURS;

    public  Hourly(String name) {
        this(name, 100.0, DEFAULT_HOURS);
    }

    public Hourly(String name, double rate) {
        this(name, rate, DEFAULT_HOURS);
    }

    public Hourly(String name, double rate, double hours) {
        super(name);
        this.rate = rate;
        this.hours = hours;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    @Override
    public double computePay() {
        return rate * hours;
    }

    @Override
    public String toString() {
        return String.format("%s, rate = %s, hours = %s", super.toString(), rate, hours);
    }
}
