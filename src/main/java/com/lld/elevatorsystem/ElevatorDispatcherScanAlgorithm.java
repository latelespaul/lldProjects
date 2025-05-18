package com.lld.elevatorsystem;

import com.lld.Main;

import java.util.*;

import static com.lld.elevatorsystem.Direction.UP;

public class ElevatorDispatcherScanAlgorithm implements  ElevartorDispatcher {
    private Elevator elevator;
    PriorityQueue<Integer> floors = new PriorityQueue<>();
    Map<Integer,Direction> floorDirectionMap = new HashMap<>();


    public ElevatorDispatcherScanAlgorithm() {

    }


    @Override
    public void dispatchElevator(int floor, Direction direction) {
        if (elevator.getCurrentFloor() == floor) {
            elevator.openDoor();
        }

        if (!elevator.isMoving()){
            elevator.moveToFloor(floor);
        }

        if (elevator.getDirection() == direction && elevator.getCurrentFloor() < floor) {
            floors.add(floor);
        }

        if (elevator.getDirection() != direction || elevator.getCurrentFloor() > floor) {
            floorDirectionMap.put(floor, direction);
        }

    }

    public void  moveToNextFloor() {
        if (!floors.isEmpty()) {
            int nextFloor = floors.poll();
            elevator.moveToFloor(nextFloor);
            elevator.openDoor();
            elevator.closeDoor();
        }
        if (floors.isEmpty() && floorDirectionMap.isEmpty()){
            elevator.setMoving(false);
            elevator.setState(State.IDLE);
            return;
        }
        if (!floorDirectionMap.isEmpty()) {
            Integer floor = elevator.getCurrentFloor();
            // get the closet floor from the map
            if (elevator.getDirection() == UP){
                // get all the floors in the map whole direction is down
                List<Integer> downFloors = new ArrayList<>();
                // stream to get all elevators which has down direction
                floorDirectionMap.entrySet().stream()
                        .filter(entry -> entry.getValue() == Direction.DOWN)
                        .forEach(entry -> downFloors.add(entry.getKey()));
                // get the closest floor from the map
                int closestFloor = Collections.min(downFloors);
                dispatchElevator(closestFloor, Direction.DOWN);
                floors.addAll(downFloors);

                // update the hashmap to remove the elements which are picked
                for (Integer floor1 : downFloors) {
                    floorDirectionMap.remove(floor1);
                }
            } else if (elevator.getDirection() == Direction.DOWN){
                // get all the floors in the map whole direction is up
                List<Integer> upFloors = new ArrayList<>();
                // stream to get all elevators which has up direction
                floorDirectionMap.entrySet().stream()
                        .filter(entry -> entry.getValue() == Direction.UP)
                        .forEach(entry -> upFloors.add(entry.getKey()));
                // get the closest floor from the map
                int closestFloor = Collections.max(upFloors);
                // update the priority que with new list
                floors.addAll(upFloors);

                // update the hashmap to remove the elements which are picked
                for (Integer floor1 : upFloors) {
                    floorDirectionMap.remove(floor1);
                }
                dispatchElevator(closestFloor, Direction.UP);
            }

        }
    }

    @Override
    public void registerElevator(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void removeElevator(Elevator elevator) {

    }
    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }
    public Elevator getElevator() {
        return elevator;
    }
}
