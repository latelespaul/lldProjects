package com.lld.elevatorsystem;

public interface ElevartorDispatcher {

    void dispatchElevator(int floor, Direction direction, int elevatorId);

    void registerElevator(Elevator elevator);
    void removeElevator(Elevator elevator);
}
