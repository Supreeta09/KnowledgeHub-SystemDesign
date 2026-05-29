package strategy;

import models.Ticket;

import java.math.BigDecimal;

public interface ChargeStrategy {
    BigDecimal calculateCharge(Ticket ticket);
}
