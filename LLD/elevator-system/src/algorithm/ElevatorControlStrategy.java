package algorithm;

import model.ElevatorController;
import model.ElevatorSystem;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ElevatorControlStrategy {
    private Queue<PendingRequests> pendingRequests = new LinkedList<>();
    private List<ElevatorController> elevatorControllers = ElevatorSystem.INSTANCE.getElevatorControllers();

    public Queue<PendingRequests> getPendingRequests() {
        return pendingRequests;
    }

    public void setPendingRequests(Queue<PendingRequests> pendingRequests) {
        this.pendingRequests = pendingRequests;
    }

    public void moveElevator(ElevatorController elevatorController) {

    }
}
