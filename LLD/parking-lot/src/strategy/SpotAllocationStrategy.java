package strategy;

import models.ParkingFloor;
import models.ParkingSpot;
import models.Vehicle;

import java.util.List;

public interface SpotAllocationStrategy {
    ParkingSpot findAvailableSpot(Vehicle vehicle, List<ParkingFloor> floors);
}

