package com.lld.elevatorsystem;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private int numberOfFloors;
    private int numberOfElevators;
    private List<Elevator> elevators;
    private List<Floor> floors;
    private final ElevatorPickerStrategy elevatorPickerStrategy;
    private final ElevartorDispatcher elevatorDispatcher;

    public Building(int numberOfFloors, int numberOfElevators) {
        this.numberOfFloors = numberOfFloors;
        this.numberOfElevators = numberOfElevators;
        this.elevators = new ArrayList<>();
        this.floors = new ArrayList<>();
        this.elevatorPickerStrategy = new OddEvenElevatorPickerStrategy();
        this.elevatorDispatcher = new ElevatorDispatcherScanAlgorithm();
        initializeBuilding();
    }
    private Building (int numberOfFloors, int numberOfElevators, ElevatorPickerStrategy elevatorPickerStrategy, ElevartorDispatcher elevatorDispatcher) {
        this.numberOfFloors = numberOfFloors;
        this.numberOfElevators = numberOfElevators;
        this.elevatorDispatcher = elevatorDispatcher;
        this.elevators = new ArrayList<>();
        this.floors = new ArrayList<>();
        this.elevatorPickerStrategy = elevatorPickerStrategy;
        initializeBuilding();
    }

    private void initializeBuilding() {
        for (int i = 0; i < numberOfElevators; i++) {
            elevators.add(new Elevator(i));
        }
        for (int i = 0; i < numberOfFloors; i++) {
            Button button =new ExternalButtons(i);
            floors.add(new Floor(i, button));
        }
        for (Elevator elevator : elevators) {
            elevatorDispatcher.registerElevator(elevator);
        }
        elevatorPickerStrategy.setElevators(elevators);

    }

}
