package com.lld.elevatorsystem;

import java.util.ArrayList;
import java.util.List;

public class OddEvenElevatorPickerStrategy implements  ElevatorPickerStrategy {
    private final List<Elevator> elevators= new ArrayList<>();

    public OddEvenElevatorPickerStrategy (List<Elevator> elevators) {
        this.elevators.addAll(elevators);
    }

    public OddEvenElevatorPickerStrategy(){
    }



   @Override
    public Elevator pickElevator(int floor, Direction direction) {

        Elevator elev;

        if (elevators.isEmpty()){
            return  null;
        }

        if (floor % 2 == 0) {
             elev = elevators.stream().filter(elevator -> elevator.getCurrentFloor() % 2 == 0
                    && elevator.getState() == State.IDLE)
            .findFirst().orElse(null);
            return elev;
        } else {
            elev = elevators.stream().filter(elevator -> elevator.getCurrentFloor() % 2 != 0
                    && elevator.getState() == State.IDLE).findFirst().orElse(null);
            return elev;
        }
    }
    public void addElevator(Elevator elevator) {
        elevators.add(elevator);
    }
    public void removeElevator(Elevator elevator) {
        elevators.remove(elevator);
    }
    public List<Elevator> getElevators() {
        return elevators;
    }
    @Override
    public void setElevators(List<Elevator> elevators) {
        this.elevators.clear();
        this.elevators.addAll(elevators);
    }


}
