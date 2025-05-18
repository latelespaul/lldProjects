package com.lld.elevatorsystem;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private int numberOfFloors;
    private int numberOfElevators;
    private Elevator elevators;
    private List<Floor> floors;
    private ElevartorDispatcher elevatorDispatcher;

    public Building(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
        this.numberOfElevators = 1;
        this.elevators = new Elevator(0);
        this.floors = new ArrayList<>();
        initializeBuilding();
    }
    public Building(int numberOfFloors, int numberOfElevators) {
        this.numberOfFloors = numberOfFloors;
        this.numberOfElevators = numberOfElevators;
        this.elevators = new Elevator(0);
        this.floors = new ArrayList<>();
        initializeBuilding();
    }
    public Building (int numberOfFloors, int numberOfElevators, ElevartorDispatcher elevatorDispatcher) {
        this.numberOfFloors = numberOfFloors;
        this.numberOfElevators = numberOfElevators;
        this.elevators = new Elevator(0);
        this.floors = new ArrayList<>();
        initializeBuilding();
    }

    private void initializeBuilding() {
        for (int i = 0; i < numberOfFloors; i++) {
            Button button =new ExternalButtons(i);
            floors.add(new Floor(i, button));
        }
//        elevatorPickerStrategy.setElevators();

    }

    public Elevator requestElevator(int floorNumber, Direction direction) {
        return elevators;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }
}
