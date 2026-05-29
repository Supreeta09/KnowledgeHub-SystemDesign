package dispatcher;

import algorithm.ElevatorSelectionStrategy;
import model.Direction;
import model.ElevatorController;
import model.ElevatorSystem;

public class ExternalDispatcher {
    public static ExternalDispatcher INSTANCE = new ExternalDispatcher();
    private ExternalDispatcher() {}

    public void submitRequest(int floor, Direction direction) {
        int elevatorId = ElevatorSystem.elevatorSelectionStrategy.selectElevator(floor, direction);
        System.out.println("Selected elevator " + elevatorId);
        for (ElevatorController elevatorController: ElevatorSystem.INSTANCE.getElevatorControllers()) {
            if (elevatorController.getId() == elevatorId) {
                elevatorController.acceptRequest(floor, direction);
            }
        }
    }
}
