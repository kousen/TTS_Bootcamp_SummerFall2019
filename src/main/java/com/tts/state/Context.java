package com.tts.state;

import java.util.Scanner;

public class Context {
    public static void main(String[] args) {
        Door door = new Door();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter (O)pen or (C)lose (or Q to quit:");
        String response = "O";
        while (!response.equals("Q")) {
            response = scanner.nextLine();
            if (response.equals("O")) {
                door.open();
            } else if (response.equals("C")) {
                door.close();
            }
        }
    }
}
