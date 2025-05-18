package com.lld.elevatorsystem;

public class Elevator {
    private int id;
    private int currentFloor;
    private Direction direction;
    private boolean isMoving;
    private State state;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0; // Assuming ground floor is 0
        this.direction = Direction.UP; // Default direction
        this.isMoving = false;
        this.state = State.IDLE; // Initially not moving
    }

    public void moveToFloor(int floor) {
        // Logic to move the elevator to the specified floor
        this.currentFloor = floor;
        this.isMoving = true;
        try {
            // Simulate elevator moving time
            System.out.println("Elevator " + id + " moving to floor: " + floor);
            Thread.sleep(1000); // Simulate door open time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        // Logic to stop the elevator
        this.isMoving = false;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public boolean isMoving() {
        return isMoving;
    }
    public void openDoor() {
        // Logic to open the elevator door
        System.out.println("Opening door at floor: " + currentFloor);
        // wait
        try {
            Thread.sleep(1000); // Simulate door open time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void closeDoor() {
        // Logic to close the elevator door
        System.out.println("Closing door at floor: " + currentFloor);
        try {
            Thread.sleep(1000); // Simulate door open time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  Direction getDirection() {
        return direction;
    }

    public void setMoving(boolean b) {
        this.isMoving = b;
    }

    public void setState(State state) {
        this.state = state;
    }
}
