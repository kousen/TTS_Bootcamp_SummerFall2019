package com.tts.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionDemo {
    public static void main(String[] args) {

        try {
            FileInputStream file = new FileInputStream("myfile");
            byte x = (byte) file.read();
            int y = x /3;
        } catch (IOException | ArithmeticException f) {
            f.printStackTrace();
        }

        int x = 3;
        int y = 0;
        try {
            int z = x / y;
        } catch (Exception e) {
            System.err.println(e.toString());
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Made it to here");


    }
}
