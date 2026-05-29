package models;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private TicketStatus ticketStatus;

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = LocalDateTime.now();
        this.ticketStatus = TicketStatus.ACTIVE;
    }

    public long getParkingDuration() {
        LocalDateTime endTime = exitTime == null ? LocalDateTime.now() : exitTime;
        long minutes = Duration.between(entryTime, endTime).toMinutes();
        long hours = (minutes + 59) / 60;
        return Math.max(hours, 1);
    }

    public void markExitTime() {
        exitTime = LocalDateTime.now();
        ticketStatus = TicketStatus.CLOSED;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }
}
