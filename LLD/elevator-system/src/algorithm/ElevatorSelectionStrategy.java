package algorithm;

import model.Direction;
import model.ElevatorController;
import model.ElevatorSystem;

import java.util.List;

public class ElevatorSelectionStrategy {
    private List<ElevatorController> elevatorControllers = ElevatorSystem.INSTANCE.getElevatorControllers();

    public int selectElevator(int floor, Direction direction) {
        return 0;
    }
}
