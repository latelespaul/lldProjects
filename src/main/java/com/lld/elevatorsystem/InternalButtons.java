package com.lld.elevatorsystem;

public class InternalButtons implements Button {
    private int floor;
    private Elevator elevator;

    public InternalButtons(int floor, Elevator elevator) {
        this.floor = floor;
        this.elevator = elevator;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public void press() {
        // Logic to handle button press
        System.out.println("Button pressed for floor: " + floor);
        // Add logic to move the elevator to the specified floor
    }
}
