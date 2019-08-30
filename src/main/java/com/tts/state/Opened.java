package com.tts.state;

public class Opened implements DoorState {
    private static Opened instance = new Opened();

    private Opened() { }

    public static Opened getInstance() {
        return instance;
    }

    @Override
    public DoorState open() {
        System.out.println("Already opened");
        return this;
    }

    @Override
    public DoorState close() {
        System.out.println("Closing door");
        return Closed.getInstance();
    }
}
