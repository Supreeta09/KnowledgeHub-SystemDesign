package dispatcher;

import model.Direction;
import model.ElevatorController;
import model.ElevatorSystem;

public class InternalDispatcher {
    public void submitRequest(int floor, Direction dir, int elevatorId) {
        for (ElevatorController elevatorController: ElevatorSystem.INSTANCE.getElevatorControllers()) {
            if (elevatorController.getId() == elevatorId) {
                elevatorController.acceptRequest(floor, dir);
            }
        }
    }
}
