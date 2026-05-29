package models;

import strategy.*;

import java.math.BigDecimal;
import java.util.List;

public class ParkingLot {
    private final List<ParkingFloor> floors;
    private final SpotAllocationStrategy allocationStrategy;
    private final ChargeStrategy chargeStrategy;

    public ParkingLot(List<ParkingFloor> floors) {
        this.floors = floors;
        this.allocationStrategy = new NearestSpotAllocationStrategy();
        this.chargeStrategy = new PeakHourChargeStrategy();
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        ParkingSpot parkingSpot = allocationStrategy.findAvailableSpot(vehicle, floors);
        if (parkingSpot == null) {
            throw new RuntimeException("Not spot available");
        }

        parkingSpot.occupy(vehicle);

        Ticket ticket = new Ticket(vehicle, parkingSpot);
        System.out.println("Vehicle " + vehicle.getLicensePlate() + " parked at " + parkingSpot.getSpotNumber());

        return ticket;
    }

    public BigDecimal unParkVehicle(Ticket ticket) {
        if (ticket == null) {
            throw new RuntimeException("Invalid ticket");
        }

        if (ticket.getTicketStatus() == TicketStatus.CLOSED) {
            throw new RuntimeException("Ticket already used");
        }

        ticket.markExitTime();

        BigDecimal fee = chargeStrategy.calculateCharge(ticket);
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        parkingSpot.vacate();

        System.out.println("Vehicle " + ticket.getVehicle().getLicensePlate() + " exited from the spot " + parkingSpot.getSpotNumber());

        return fee;
    }

    public void displayAvailability() {
        for (ParkingFloor floor: floors) {
            System.out.println("Floor: " + floor.getFloorNumber());
            for (ParkingSpot spot: floor.getParkingSpots()) {
                System.out.println(spot.getSpotNumber() + " -> " + (spot.isAvailable() ? "AVAILABLE" : "OCCUPIED"));
            }
        }
    }
}
