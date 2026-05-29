package model;

import dispatcher.ExternalDispatcher;

public class ExternalButton extends Button{
    private ExternalDispatcher externalDispatcher = ExternalDispatcher.INSTANCE;
    private Direction direction;

    public Direction getDirection() {
        return direction;
    }

    public void pressButton(int floor, Direction dir) {
        direction = dir;
        System.out.println("Pressed " + direction + " from floor " + floor);
        externalDispatcher.submitRequest(floor, direction);
    }
}
