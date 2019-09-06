package com.tts.lambdas;

public class RunnableDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside anonymous inner class");
            }
        }).start();

        new Thread(() -> System.out.println("Inside expression lambda")).start();
        new Thread(() -> {
            System.out.println("Inside block lambda");
        }).start();

        Runnable lambda = () -> System.out.println("Assigned to local variable");
        new Thread(lambda).start();
    }
}
