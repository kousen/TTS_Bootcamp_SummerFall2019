package com.tts.equalsdemo;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class PointV1Test {

    @Test
    public void checkEqualsOperator() {
        PointV1 p1 = new PointV1(3, 5);
        PointV1 p2 = new PointV1(3, 5);
        PointV1 p3 = p1;
        assertFalse(p1 == p2);
        assertNotSame(p1, p2);
        assertTrue(p1 == p3);
        assertSame(p1, p3);
    }

    @Test
    public void checkEqualsMethod() {
        PointV1 p1 = new PointV1(3, 5);
        PointV1 p2 = new PointV1(3, 5);
        assertEquals(p1, p2);

        assertFalse(p1.equals("abc"));
    }

    @Test
    public void checkSizeOfSet() {
        PointV1 p1 = new PointV1(3, 5);
        PointV1 p2 = new PointV1(3, 5);
        Set<PointV1> points = new HashSet<>();
        points.add(p1); points.add(p2);
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(points.size());
    }
}