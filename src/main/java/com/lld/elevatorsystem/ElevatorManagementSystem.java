package com.lld.elevatorsystem;

import java.util.List;
import java.util.Scanner;

public class ElevatorManagementSystem {
    private static int numberOfBuildings;
    private ElevatorPickerStrategy elevatorPickerStrategy;
    private static List<Building> buildings;
    private  static final ElevatorPickerStrategy defaultElevatorPickerStrategy = new OddEvenElevatorPickerStrategy();

    public ElevatorManagementSystem (ElevatorPickerStrategy elevatorPickerStrategy) {
        this.elevatorPickerStrategy = elevatorPickerStrategy;
    }

    public void setElevatorPickerStrategy() {
        this.elevatorPickerStrategy = new OddEvenElevatorPickerStrategy();
    }
    public void requestElevator(int floorNumber, Direction direction) {
        Elevator selectedElevator = elevatorPickerStrategy.pickElevator(floorNumber, direction);
        selectedElevator.moveToFloor(floorNumber);
    }

    public static void startSystem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Buildings:");
        numberOfBuildings = sc.nextInt();
        initializeBuilding(sc);
        initializeSystem();
        System.out.println("Elevator Management System Initialized with " + numberOfBuildings + " buildings.");

    }
    private static void initializeBuilding(Scanner sc) {
        for (int i = 0; i < numberOfBuildings; i++) {
            System.out.println("Enter the number of Floors for Building " + (i + 1) + ":");
            int numberOfFloors = sc.nextInt();
            System.out.println("Enter the number of Elevators for Building " + (i + 1) + ":");
            int numberOfElevators = sc.nextInt();
            buildings.add(new Building(numberOfFloors, numberOfElevators));
        }
    }
    private static void initializeSystem() {

    }

    public static Elevator requestElevator(int buildingId, int floorNumber, Direction direction) {
        if (buildingId < 0 || buildingId >= numberOfBuildings) {
            throw new IllegalArgumentException("Invalid building ID");
        }
        Building building = buildings.get(buildingId);
        return building.requestElevator(floorNumber, direction);
    }
}
