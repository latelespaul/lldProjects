package com.lld.elevatorsystem;

public class ElevatorControllerSystem {
    private int numberOfElevators;
    private int numberOfFloors;
    private Elevator[] elevators;
    private Floor[] floors;
    ElevatorPickerStrategy elevatorPickerStrategy;
    ElevartorDispatcher elevatorDispatcher;

    public ElevatorControllerSystem(int numberOfElevators, int numberOfFloors, ElevatorPickerStrategy elevatorPickerStrategy) {
        initialize(numberOfElevators, numberOfFloors, elevatorPickerStrategy);
    }

    private void initialize(int numberOfElevators, int numberOfFloors, ElevatorPickerStrategy elevatorPickerStrategy) {
        this.numberOfElevators = numberOfElevators;
        this.numberOfFloors = numberOfFloors;
        this.elevatorPickerStrategy = elevatorPickerStrategy;
        initializeElevators();
        initializeFloors();
        initializeDispatcher();
    }

    private void initializeDispatcher() {
        elevatorDispatcher = new ElevatorDispatcherScanAlgorithm();
        for (int i = 0; i < numberOfElevators; i++) {
            elevatorDispatcher.registerElevator(elevators[i]);
        }
    }

    private void initializeFloors() {
        floors = new Floor[numberOfFloors];
        for (int i = 0; i < numberOfFloors; i++) {
            Button button = new ExternalButtons(i);
            floors[i] = new Floor(i, button);
        }
    }

    private void initializeElevators() {
        for (int i = 0; i < numberOfElevators; i++) {
            elevators[i] = new Elevator(i);
        }
    }

    public void requestElevator(int floorNumber, Direction direction) {
        // Logic to request an elevator
        Elevator selectedElevator = elevatorPickerStrategy.pickElevator(floorNumber, direction);
        if (selectedElevator != null) {
            selectedElevator.moveToFloor(floorNumber);
        } else {
            System.out.println("No available elevator.");
        }
    }


    private  void validation(int elevatorId, int targetFloor) {
        if (elevatorId < 0 || elevatorId >= numberOfElevators) {
            throw new IllegalArgumentException("Invalid elevator ID");
        }
        if (targetFloor < 0 || targetFloor >= numberOfFloors) {
            throw new IllegalArgumentException("Invalid target floor");
        }
    }

}