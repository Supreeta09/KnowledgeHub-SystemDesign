package strategy;

import models.ParkingFloor;
import models.ParkingSpot;
import models.Vehicle;

import java.util.List;

public class NearestSpotAllocationStrategy implements SpotAllocationStrategy {

    @Override
    public ParkingSpot findAvailableSpot(Vehicle vehicle, List<ParkingFloor> floors) {
        for (ParkingFloor floor: floors) {
            for (ParkingSpot spot: floor.getParkingSpots()) {
                if (spot.isAvailable() && spot.canFitVehicle(vehicle)) {
                    return spot;
                }
            }
        }
        return null;
    }
}
