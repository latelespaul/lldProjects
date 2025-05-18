package com.lld.elevatorsystem;

public interface ElevartorDispatcher {

    void dispatchElevator(int floor, Direction direction);

    void registerElevator(Elevator elevator);
    void removeElevator(Elevator elevator);
}
