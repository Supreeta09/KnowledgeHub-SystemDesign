import algorithm.ElevatorControlStrategy;
import algorithm.ElevatorSelectionStrategy;
import model.Direction;
import model.ElevatorController;
import model.ElevatorSystem;
import model.Floor;

public class ElevatorSystemApplication {
    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = ElevatorSystem.INSTANCE;
        elevatorSystem.setElevatorControlStrategy(new ElevatorControlStrategy());
        elevatorSystem.setElevatorSelectionStrategy(new ElevatorSelectionStrategy());

        int totalFloors = 10;
        for (int i = 1; i<= totalFloors; i++) {
            elevatorSystem.addFloors(new Floor(1));
        }

        System.out.println("Person at floor 1 presses UP button");
        for (Floor floor: ElevatorSystem.INSTANCE.floors) {
            if (floor.getFloor() == 1) {
                floor.pressButton(Direction.UP);
            }
        }

        System.out.println("Person at floor 5 presses UP Button");
        for (Floor floor: ElevatorSystem.INSTANCE.floors) {
            if (floor.getFloor() == 5) {
                floor.pressButton(Direction.UP);
            }
        }

        System.out.println("Person in elevator 2 presses 10");
        for (ElevatorController controller: ElevatorSystem.INSTANCE.getElevatorControllers()) {
            if (controller.getId() == 2) {
                controller.getElevatorCar().pressButton(10);
            }
        }

        System.out.println("Person in elevator 2 presses 6");
        for (ElevatorController controller: ElevatorSystem.INSTANCE.getElevatorControllers()) {
            if (controller.getId() == 2) {
                controller.getElevatorCar().pressButton(6);
            }
        }

        System.out.println("Person at floor 7 presses DOWN button");
        for (Floor floor: ElevatorSystem.INSTANCE.floors) {
            if (floor.getFloor() == 7) {
                floor.pressButton(Direction.DOWN);
            }
        }

        System.out.println("Person in elevator 3 presses 1");
        for (ElevatorController controller: ElevatorSystem.INSTANCE.getElevatorControllers()) {
            if (controller.getId() == 3) {
                controller.getElevatorCar().pressButton(1);
            }
        }
    }

}
