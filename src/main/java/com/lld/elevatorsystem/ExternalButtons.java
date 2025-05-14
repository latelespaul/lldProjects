package com.lld.elevatorsystem;

public class ExternalButtons implements  Button{
    private int floor;
    private boolean isPressed;

    public ExternalButtons(int floor) {
        this.floor = floor;
        this.isPressed = false;
    }

    @Override
    public int getFloor() {
        return floor;
    }

    @Override
    public void press() {
        isPressed = true;
        System.out.println("Button pressed for floor: " + floor);
    }

    public boolean isPressed() {
        return isPressed;
    }
}
