package models;

public interface ParkingSpot {
    boolean isAvailable();
    void occupy(Vehicle vehicle);
    void vacate();
    String getSpotNumber();
    boolean canFitVehicle(Vehicle vehicle);
}
