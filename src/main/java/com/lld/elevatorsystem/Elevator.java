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
    public int getId() {
        return id;
    }
    public Direction getDirection() {
        return direction;
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
    public void setMoving(boolean moving) {
        isMoving = moving;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setDirectionAndState(Direction direction, State state) {
        this.direction = direction;
        this.state = state;
    }
    public void setMovingAndState(boolean moving, State state) {
        isMoving = moving;
        this.state = state;
    }
    public void setMovingAndDirection(boolean moving, Direction direction) {
        isMoving = moving;
        this.direction = direction;
    }
    public void setMovingAndDirectionAndState(boolean moving, Direction direction, State state) {
        isMoving = moving;
        this.direction = direction;
        this.state = state;
    }
    public void setCurrentFloorAndState(int currentFloor, State state) {
        this.currentFloor = currentFloor;
        this.state = state;
    }
    public void setCurrentFloorAndDirection(int currentFloor, Direction direction) {
        this.currentFloor = currentFloor;
        this.direction = direction;
    }
    public void setCurrentFloorAndDirectionAndState(int currentFloor, Direction direction, State state) {
        this.currentFloor = currentFloor;
        this.direction = direction;
        this.state = state;
    }
    public void setCurrentFloorAndMoving(int currentFloor, boolean moving) {
        this.currentFloor = currentFloor;
        isMoving = moving;
    }

}
