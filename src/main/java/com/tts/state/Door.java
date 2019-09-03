package com.tts.state;

@SuppressWarnings("WeakerAccess")
public class Door {
    private DoorState state = Closed.getInstance();

    public DoorState getState() {
        return state;
    }

    public void setState(DoorState state) {
        this.state = state;
    }

    public void open() {
        state = state.open();
    }

    public void close() {
        state = state.close();
    }
}
