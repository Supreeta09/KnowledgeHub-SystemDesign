package model;

import dispatcher.InternalDispatcher;

import java.util.ArrayList;
import java.util.List;

public class InternalButton extends Button{
    private InternalDispatcher internalDispatcher;
    private List<Integer> floors= new ArrayList<Integer>();

    public InternalButton() {
        internalDispatcher = new InternalDispatcher();
    }

    @Override
    public void pressButton(int floor, Direction direction, int elevatorId) {
        floors.add(floor);
        System.out.println("Pressed floor "+ floor + " from elevator "+ elevatorId);
        internalDispatcher.submitRequest(floor, direction, elevatorId);
    }
}
