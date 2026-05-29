package model;

public class Floor {
    private int floor;
    private Display display;
    private Button button;

    public Floor(int floor) {
        this.floor = floor;
        button = new ExternalButton();
    }

    public void pressButton(Direction direction) {
        button.pressButton(floor, direction);
    }

    public void setDisplay(int floor, Direction direction) {
        display.setFloor(floor);
        display.setDirection(direction);
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
