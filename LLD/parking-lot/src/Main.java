import models.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<ParkingFloor> floors = new ArrayList<>();

        ParkingFloor floor1 = new ParkingFloor("01");
        floor1.addParkingSpots(new CompactSpot("C1"));
        floor1.addParkingSpots(new RegularSpot("R1"));
        floor1.addParkingSpots(new OversizedSpot("O1"));

        floors.add(floor1);

        ParkingLot parkingLot = new ParkingLot(floors);

        Vehicle car1 = new Car("KA01AB1234");
        Vehicle bike1 = new MotorCycle("KA02XY9999");
        Vehicle truck1 = new Truck("KA03TR7777");

        Ticket t1 = parkingLot.parkVehicle(car1);
        Ticket t2 = parkingLot.parkVehicle(bike1);

        Ticket t3 = parkingLot.parkVehicle(truck1);

        BigDecimal fee1 = parkingLot.unParkVehicle(t1);
        System.out.println("Fee for car1 = " + fee1);

        BigDecimal fee2 = parkingLot.unParkVehicle(t2);
        System.out.println("Fee for bike1 = " + fee2);

        BigDecimal fee3 = parkingLot.unParkVehicle(t3);
        System.out.println("Fee for truck1 = " + fee3);

        parkingLot.displayAvailability();
    }
}
