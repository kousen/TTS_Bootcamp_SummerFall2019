package com.tts.state;

public class Closed implements DoorState {
    private static Closed INSTANCE;

    private Closed() {}

    public static Closed getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Closed();
        }
        return INSTANCE;
    }

    @Override
    public DoorState open() {
        System.out.println("Opening door");
        return Opened.getInstance();
    }

    @Override
    public DoorState close() {
        System.out.println("Already closed");
        return this;
    }
}
