package com.tts;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ArraysTests {
    private String[] strings = {};
    private int[] ints;

    @Test
    public void accessArrayOfInteger() {
        ints = new int[5];
        for (int n : ints) {
            assertEquals(0, n);
        }

        for (int i = 0; i < ints.length; i++) {
            assertEquals(0, ints[i]);
        }
    }

    @Test
    public void intArrayWithData() {
        ints = new int[5];
        ints[0] = 3;
        ints[1] = 1;
        ints[2] = 4;
        assertEquals(3, ints[0]);
        assertEquals(1, ints[1]);
        assertEquals(4, ints[2]);
        assertEquals(0, ints[3]);
        assertEquals(0, ints[4]);
    }

    @Test
    public void stringArray() {
        String[] myStrings = new String[6];
        myStrings[0] = "this";
        myStrings[1] = "is";
        myStrings[2] = "an";
        myStrings[3] = "array";
        myStrings[4] = "of";
        myStrings[5] = "strings";

        for (String s : myStrings) {
            assertNotNull(s);
        }

        // Really ugly
        System.out.println(myStrings);

        System.out.println(Arrays.asList(myStrings));

    }

    @Test
    public void checkReference() {
        assertNotNull(strings);
    }

    //@Test(expected = NullPointerException.class)
    @Test
    public void nullReferenceThrowsException() {
        int length = strings.length;
        assertEquals(0, length);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void accessZeroElementOnNullArray() {
        String s = strings[0];
    }
}
