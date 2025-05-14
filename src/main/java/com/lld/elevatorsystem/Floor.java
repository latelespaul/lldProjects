package com.lld.elevatorsystem;

public class Floor {
    private int floorNumber;
    private Button button;

    public Floor(int floorNumber, Button button) {
        this.floorNumber = floorNumber;
        this.button = button;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public Button getButton() {
        return button;
    }
}
