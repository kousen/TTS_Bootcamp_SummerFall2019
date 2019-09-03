package com.tts.before;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void createPointFromXY() {
        Point p = new Point(3, 4);
        assertEquals(3, p.getX(), 0.0001);
        assertEquals(4, p.getY(), 0.0001);
        System.out.println(p);
    }

    @Test
    public void createPointFromRTheta() {
        Point p = Point.fromRTheta(1, Math.PI);
        System.out.println(p);
    }
}