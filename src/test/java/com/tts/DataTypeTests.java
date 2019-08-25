package com.tts;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DataTypeTests {
    private int methodCount;
    private String className;

    @Test
    public void checkDefaultsForAttributes() {
        assertEquals(0, methodCount);
        assertNull(className);
    }

    @Test
    public void incrementMethodCount() {
        int mainInt = 1;
        methodCount += mainInt;
        assertEquals(1, methodCount);
    }

    @Test
    public void castFloatToInt() {
        float f = 856.2f;
        int castFloat = (int) f;
        System.out.println("Float: " + f + ", Cast Float: " + castFloat);
    }

    @Test
    public void testAddition() {
        int x = 5;
        int y = 10;
        int z = x + y;
        assertEquals(15, z);
    }
}
