package com.lld.elevatorsystem;

import java.util.List;

public interface ElevatorPickerStrategy {

    Elevator pickElevator(int floor, Direction direction);

    void setElevators(List<Elevator> elevators);
}
