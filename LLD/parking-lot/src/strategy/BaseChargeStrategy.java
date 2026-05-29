package strategy;

import models.Ticket;
import models.VehicleSize;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BaseChargeStrategy implements ChargeStrategy {
    private static final Map<VehicleSize, BigDecimal> rates = new HashMap<>();
    static {
        rates.put(VehicleSize.SMALL, BigDecimal.valueOf(20));
        rates.put(VehicleSize.MEDIUM, BigDecimal.valueOf(50));
        rates.put(VehicleSize.LARGE, BigDecimal.valueOf(100));
    }

    @Override
    public BigDecimal calculateCharge(Ticket ticket) {
        long hours = ticket.getParkingDuration();

        BigDecimal rate = rates.get(ticket.getVehicle().getSize());

        return rate.multiply(BigDecimal.valueOf(hours));
    }
}
