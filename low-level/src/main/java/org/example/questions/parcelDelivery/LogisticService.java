package org.example.questions.parcelDelivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class LogisticService {
	private Map<String, LogisticOrder> logisticOrderMap;
	private List<NotificationService> notificationServiceList;

	public LogisticService() {
		this.logisticOrderMap = new ConcurrentHashMap<>();
		this.notificationServiceList = new ArrayList<>();
	}

	public void addNotificationService(NotificationService notificationService) {
		this.notificationServiceList.add(notificationService);
	}

	public LogisticOrder createOrder(CreateOrderRequest request) {
		LogisticOrder logisticOrder = new LogisticOrder(request);
		logisticOrderMap.put(logisticOrder.getId(), logisticOrder);
		return logisticOrder;
	}

	public void updateOrderStatus(String logisticOrderId, Status newStatus) {
		LogisticOrder logisticOrder = logisticOrderMap.get(logisticOrderId);
		if (Objects.isNull(logisticOrder)) {
			System.out.println("Order for id = " + logisticOrderId + " not found");
			return;
		}

		if (checkOrderStatusUpdate(logisticOrder.getStatus(), newStatus)) {
			logisticOrder.setStatus(newStatus);
			notifyCustomerForOrderStatusUpdate(logisticOrder, newStatus);
		} else {
			System.out.println("Incorrect status to update, please check");
		}
	}

	public List<LogisticOrder> getCreatedLogisticOrders() {
		return this.logisticOrderMap.values().stream()
				.filter(logisticOrder -> logisticOrder.getStatus() == Status.CREATED).collect(Collectors.toList());
	}

	private void notifyCustomerForOrderStatusUpdate(LogisticOrder logisticOrder, Status newStatus) {
		this.notificationServiceList.forEach(notificationService -> {
			notificationService.notifyCustomer(logisticOrder, newStatus);
		});
	}

	private boolean checkOrderStatusUpdate(Status oldStatus, Status newStatus) {
		switch (newStatus) {
			case CREATED, PICKED_UP -> {
				return oldStatus == Status.CREATED;
			}

			case IN_TRANSIT -> {
				return oldStatus == Status.PICKED_UP;
			}

			case OUT_FOR_DELIVERY -> {
				return oldStatus == Status.IN_TRANSIT;
			}

			case DELIVERED -> {
				return oldStatus == Status.OUT_FOR_DELIVERY;
			}

			case RETURNED -> {
				return oldStatus == Status.IN_TRANSIT || oldStatus == Status.OUT_FOR_DELIVERY;
			}

			default -> {
				return false;
			}
		}
	}
}
