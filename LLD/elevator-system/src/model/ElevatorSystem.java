package model;

import algorithm.ElevatorControlStrategy;
import algorithm.ElevatorSelectionStrategy;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    private List<ElevatorController> elevatorControllers = new ArrayList<>();
    public static ElevatorControlStrategy elevatorControlStrategy;
    public static ElevatorSelectionStrategy elevatorSelectionStrategy;
    public List<Floor> floors = new ArrayList<>();

    public static ElevatorSystem INSTANCE = new ElevatorSystem();
    private ElevatorSystem() {}

    public List<ElevatorController> getElevatorControllers() {
        return elevatorControllers;
    }

    public void addElevatorController(ElevatorController controller) {
        elevatorControllers.add(controller);
    }

    public void removeElevatorController(ElevatorController controller) {
        elevatorControllers.remove(controller);
    }

    public void setElevatorControlStrategy(ElevatorControlStrategy controlStrategy) {
        this.elevatorControlStrategy = controlStrategy;
    }

    public void setElevatorSelectionStrategy(ElevatorSelectionStrategy selectionStrategy) {
        this.elevatorSelectionStrategy = selectionStrategy;
    }

    public void addFloors(Floor floor) {
        floors.add(floor);
    }
}
