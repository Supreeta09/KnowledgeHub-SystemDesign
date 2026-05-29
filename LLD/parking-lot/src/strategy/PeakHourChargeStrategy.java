package strategy;

import models.Ticket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class PeakHourChargeStrategy implements ChargeStrategy {
    private final BaseChargeStrategy baseChargeStrategy = new BaseChargeStrategy();

    @Override
    public BigDecimal calculateCharge(Ticket ticket) {
        BigDecimal base = baseChargeStrategy.calculateCharge(ticket);

        long hour = LocalDateTime.now().getHour();

        boolean peak = hour >= 18 && hour <= 22;

        if (peak) {
            return base.multiply(BigDecimal.valueOf(1.5)).setScale(2, RoundingMode.HALF_UP);
        }

        return base;
    }
}
