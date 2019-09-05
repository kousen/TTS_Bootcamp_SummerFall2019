package com.tts.exceptions;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ExceptionTests {

    @Test
    public void catchArrayIndexExc() {
        try {
            String[] theMessage = {"exceptions","are","cool"};
            String s = theMessage[100];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
