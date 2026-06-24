package org.example.questions.parcelDelivery;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DeliveryServiceManager {
	private LogisticService logisticService;
	private Map<DeliveryType, DeliveryService> deliveryServiceMap;

	public DeliveryServiceManager(LogisticService logisticService) {
		this.logisticService = logisticService;
		this.deliveryServiceMap = new ConcurrentHashMap<>();

		this.deliveryServiceMap.put(DeliveryType.NORMAL, new NormalDeliveryService());
		this.deliveryServiceMap.put(DeliveryType.EXPRESS, new ExpressDeliveryService());
	}

	public void pickOrdersForDelivery() {
		List<LogisticOrder> createdLogisticOrders = logisticService.getCreatedLogisticOrders();

		for (LogisticOrder logisticOrder : createdLogisticOrders) {
			DeliveryType deliveryType = logisticOrder.getDeliveryType();
			DeliveryService deliveryService = deliveryServiceMap.get(deliveryType);

			if (deliveryService.isDeliveryServiceAvaiable(logisticOrder)) {
				LocalDateTime calculateETA = deliveryService.calculateETA(logisticOrder);
				BigDecimal calculateCost = deliveryService.calculateCostEstimate(logisticOrder);
				BigDecimal calculateDistance = deliveryService.calculateTotalDistance(logisticOrder);

				logisticOrder.setDeliveryDate(calculateETA);
				logisticOrder.setTotalCost(calculateCost);
				logisticOrder.setTotalDistance(calculateDistance);

				logisticService.updateOrderStatus(logisticOrder.getId(), Status.PICKED_UP);
				deliveryService.updateEfficiencyMap(logisticOrder);
			} else {
				System.out.println("Logistic order cannot be served in current-time");
			}
		}
	}

	public void markOrderAsInTransit(String logisticOrderId) {
		logisticService.updateOrderStatus(logisticOrderId, Status.IN_TRANSIT);
	}

	public void markOrderAsOutForDelivery(String logisticOrderId) {
		logisticService.updateOrderStatus(logisticOrderId, Status.OUT_FOR_DELIVERY);
	}

	public void markOrderAsDelivered(String logisticOrderId) {
		logisticService.updateOrderStatus(logisticOrderId, Status.DELIVERED);
	}

	public void markOrderAsReturned(String logisticOrderId) {
		logisticService.updateOrderStatus(logisticOrderId, Status.RETURNED);
	}

	public void markOrderAsCancelled(String logisticOrderId) {
		logisticService.updateOrderStatus(logisticOrderId, Status.CANCELLED);
	}
}
