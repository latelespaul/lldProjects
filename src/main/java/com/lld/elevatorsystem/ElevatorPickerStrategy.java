package com.lld.elevatorsystem;

public interface ElevatorPickerStrategy {

    Elevator pickElevator(int floor, Direction direction);
}
