package models;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private final String floorId;
    private final List<ParkingSpot> parkingSpots;

    public ParkingFloor(String floorId) {
        this.floorId = floorId;
        this.parkingSpots = new ArrayList<>();
    }

    public String getFloorNumber() {
        return floorId;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void addParkingSpots(ParkingSpot parkingSpot) {
        parkingSpots.add(parkingSpot);
    }
}
