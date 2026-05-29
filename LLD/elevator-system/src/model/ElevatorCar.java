package model;

public class ElevatorCar {
    private int id;
    private Door door;
    private Display display;
    private Button button;
    private int currFloor;
    private Direction direction;

    public ElevatorCar(int id) {
        this.id = id;
        door = new Door();
        display = new Display();
        currFloor = 0;
        direction = Direction.IDLE;
        button = new InternalButton();
    }

    public void move(Direction direction, int floor) {
        System.out.println("Elevator " + id + " moving " + direction);
        System.out.println("Elevator " + id + " stops at " + floor);

        door.open(id);
        door.close(id);
    }

    public void pressButton(int floor) {
        Direction dir = Direction.IDLE;
        if (floor > currFloor) {
            dir = Direction.UP;
        } else {
            dir = Direction.DOWN;
        }
        button.pressButton(floor, dir, id);
    }

    private void setDisplay() {
        display.setFloor(currFloor);
        display.setDirection(direction);
    }
}
