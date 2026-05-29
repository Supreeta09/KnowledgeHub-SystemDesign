package models;

public class RegularSpot implements ParkingSpot {
    private final String spotNumber;
    private Vehicle vehicle;

    public RegularSpot(String spotNumber) {
        this.spotNumber = spotNumber;
    }

    @Override
    public boolean isAvailable() {
        return vehicle == null;
    }

    @Override
    public void occupy(Vehicle vehicle) {
        if (!isAvailable()) {
            throw new RuntimeException("Spot already occupied");
        }
        vehicle = vehicle;
    }

    @Override
    public void vacate() {
        vehicle = null;
    }


    @Override
    public String getSpotNumber() {
        return spotNumber;
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.getSize() == VehicleSize.MEDIUM;
    }
}
