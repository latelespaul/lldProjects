package com.lld.elevatorsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElevatorManagementSystem {
    private static int numberOfBuildings;

    private ElevatorControllerSystem elevatorControllerSystem;
    private static List<Building> buildings = new ArrayList<>();
    private ElevatorPickerStrategy elevatorPickerStrategy;

    public ElevatorManagementSystem () {
        buildings = new ArrayList<>();
    }
    public ElevatorManagementSystem (ElevatorPickerStrategy elevatorPickerStrategy) {
        this.elevatorPickerStrategy = elevatorPickerStrategy;
    }

    public void requestElevator(int floorNumber, Direction direction) {
        Elevator selectedElevator = elevatorPickerStrategy.pickElevator(floorNumber, direction);
        selectedElevator.moveToFloor(floorNumber);
    }

    public void startSystem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Buildings:");
        numberOfBuildings = sc.nextInt();
        initializeBuilding(sc);
        initializeSystem();
        System.out.println("Elevator Management System Initialized with " + numberOfBuildings + " buildings." +
                " Each building has " + buildings.get(0).getNumberOfFloors() + " floors.");
        System.out.println("Enter the floor number to request an elevator:");
        int requestedFloor = sc.nextInt();
        System.out.println("Enter the direction (UP/DOWN):");
        String directionInput = sc.next();
        Direction direction = Direction.valueOf(directionInput.toUpperCase());
        // initialize elevator manager for each building
        for (int i = 0; i < numberOfBuildings; i++) {
            Elevator elevator = requestElevator(i, requestedFloor, direction);
            Building building = buildings.get(i);
            ElevatorDispatcherScanAlgorithm elevatorDispatcher = new ElevatorDispatcherScanAlgorithm();
            elevatorDispatcher.setElevator(elevator);
            elevatorControllerSystem = new ElevatorControllerSystem(elevatorPickerStrategy, building, elevatorDispatcher);
            elevatorControllerSystem.requestElevator(requestedFloor, direction);
        }

    }
    private static void initializeBuilding(Scanner sc) {
        for (int i = 0; i < numberOfBuildings; i++) {
            System.out.println("Enter the number of Floors for Building " + (i + 1) + ":");
            int numberOfFloors = sc.nextInt();
            buildings.add(new Building(numberOfFloors));
        }
    }
    private static void initializeSystem() {
        for (int i = 0; i < numberOfBuildings; i++) {
            Building building = buildings.get(i);
        }

    }

    public static Elevator requestElevator(int buildingId, int floorNumber, Direction direction) {
        if (buildingId < 0 || buildingId >= numberOfBuildings) {
            throw new IllegalArgumentException("Invalid building ID");
        }
        Building building = buildings.get(buildingId);
        return building.requestElevator(floorNumber, direction);
    }
}
