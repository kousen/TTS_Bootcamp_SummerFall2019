package com.tts.before;

public class Point {
    public static final double DEFAULT_X = 3.0;
    public static final double DEFAULT_Y = 4.0;

    private double x;
    private double y;

    public Point() {
        this(DEFAULT_X, DEFAULT_Y);
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

//    public Point(double r, double theta) {
//        this.x = r * Math.cos(theta);
//        this.y = r * Math.sin(theta);
//    }

    public double getDistance() {
        return Math.sqrt(x * x + y * y);
    }

    public static Point fromRTheta(double r, double theta) {
        return new Point(r * Math.cos(theta), r * Math.sin(theta));
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
