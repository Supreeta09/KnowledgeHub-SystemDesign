package model;

import algorithm.PendingRequests;

public class ElevatorController {
    private int id;
    private ElevatorCar elevatorCar;

    public ElevatorCar getElevatorCar() {
        return elevatorCar;
    }

    public int getId() {
        return id;
    }

    public ElevatorController(int id) {
        this.id = id;
        elevatorCar = new ElevatorCar(id);
    }

    public void acceptRequest(int floor, Direction direction) {
        ElevatorSystem.elevatorControlStrategy.getPendingRequests().add(new PendingRequests(floor, direction));
        controlElevatorCar();
    }

    private void controlElevatorCar() {
        ElevatorSystem.elevatorControlStrategy.moveElevator(this);
        System.out.println("Elevator moving...");
    }
}
