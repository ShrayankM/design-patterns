package org.example.questions.parcelDelivery;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class NormalDeliveryService implements DeliveryService {
	private static final int WEEKLY_CAPACITY = 15;
	private static final int WEEKS_TO_TRACK = 52;

	private Map<String, Integer> efficiencyMap;

	public NormalDeliveryService() {
		this.efficiencyMap = new ConcurrentHashMap<>();
		calculateHashAndSetEfficiencyMap();
	}

	@Override
	public LocalDateTime calculateETA(LogisticOrder logisticOrder) {
		return null;
	}

	@Override
	public BigDecimal calculateCostEstimate(LogisticOrder logisticOrder) {
		return null;
	}

	@Override
	public BigDecimal calculateTotalDistance(LogisticOrder logisticOrder) {
		return null;
	}

	@Override
	public boolean isDeliveryServiceAvaiable(LogisticOrder logisticOrder) {
		LocalDateTime pickupDateTime = logisticOrder.getPickupDate();
		if (pickupDateTime == null) {
			return false;
		}

		LocalDate weekStart = pickupDateTime.toLocalDate().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
		LocalDate weekEnd = weekStart.plusDays(6);
		String weekHash = buildWeekHash(weekStart, weekEnd);

		Integer remainingCapacity = efficiencyMap.get(weekHash);
		return remainingCapacity != null && remainingCapacity > 0;
	}

	@Override
	public void updateEfficiencyMap(LogisticOrder logisticOrder) {

	}

	private void calculateHashAndSetEfficiencyMap() {
		LocalDate weekStart = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
		for (int week = 0; week < WEEKS_TO_TRACK; week++) {
			LocalDate weekEnd = weekStart.plusDays(6);
			String weekHash = buildWeekHash(weekStart, weekEnd);
			efficiencyMap.put(weekHash, WEEKLY_CAPACITY);
			weekStart = weekStart.plusWeeks(1);
		}
	}

	private String buildWeekHash(LocalDate startDate, LocalDate endDate) {
		return Integer.toHexString(Objects.hash(startDate, endDate));
	}
}
