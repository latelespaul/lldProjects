package com.lld.elevatorsystem;

public class ElevatorControllerSystem {
    ElevatorPickerStrategy elevatorPickerStrategy;
    ElevartorDispatcher elevatorDispatcher;
    Building building;

    public ElevatorControllerSystem(ElevatorPickerStrategy elevatorPickerStrategy, Building building, ElevartorDispatcher elevatorDispatcher) {
        this.elevatorPickerStrategy = elevatorPickerStrategy;
        this.building = building;
        this.elevatorDispatcher = elevatorDispatcher;
    }




    public void requestElevator(int floorNumber, Direction direction) {
        // logic to reuquest elevator dispatcher
        if (floorNumber < 0 || floorNumber > building.getNumberOfFloors()) {
            System.out.println("Invalid floor number");
            return;
        }
        elevatorDispatcher.dispatchElevator(floorNumber, direction);
    }
}