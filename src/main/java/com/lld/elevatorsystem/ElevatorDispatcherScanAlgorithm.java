package com.lld.elevatorsystem;

import java.util.ArrayList;
import java.util.List;

public class ElevatorDispatcherScanAlgorithm implements  ElevartorDispatcher {
    private List<Elevator> elevators;

    public ElevatorDispatcherScanAlgorithm() {
        this.elevators = new ArrayList<>();
    }


    @Override
    public void dispatchElevator(int floor, Direction direction, int elevatorId) {

    }

    @Override
    public void registerElevator(Elevator elevator) {

    }

    @Override
    public void removeElevator(Elevator elevator) {

    }

    public List<Elevator> getElevators() {
        return elevators;
    }

    public void setElevators(List<Elevator> elevators) {
        this.elevators = elevators;
    }
}
