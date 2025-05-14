package com.lld.elevatorsystem;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private int numberOfFloors;
    private int numberOfElevators;
    private List<Elevator> elevators;
    private List<Floor> floors;

    public Building(int numberOfFloors, int numberOfElevators) {
        this.numberOfFloors = numberOfFloors;
        this.numberOfElevators = numberOfElevators;
        this.elevators = new ArrayList<>();
        this.floors = new ArrayList<>();
        initializeBuilding();
    }

    private void initializeBuilding() {
        for (int i = 0; i < numberOfElevators; i++) {
            elevators.add(new Elevator());
        }
        for (int i = 0; i < numberOfFloors; i++) {
            Button button =new ExternalButtons(i);
            floors.add(new Floor(i, button));
        }
    }
}
