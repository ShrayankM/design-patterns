package org.example.questions.parkingLot;

import java.math.BigDecimal;
import java.util.Map;

public class BasePriceStrategy implements PricingStrategy {
	private final static Map<VehicleSize, BigDecimal> basePriceMapping = Map.of(
			VehicleSize.SMALL, BigDecimal.valueOf(10.99),
			VehicleSize.MEDIUM, BigDecimal.valueOf(15.99),
			VehicleSize.LARGE, BigDecimal.valueOf(25.99)
	);

	@Override
	public BigDecimal calculatePrice(Ticket ticket, BigDecimal inputFare) {
		VehicleSize vehicleSize = ticket.getTicketVehicleSize();
		inputFare =  inputFare.add(basePriceMapping.get(vehicleSize));
		return inputFare;
	}
}
