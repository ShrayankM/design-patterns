package org.example.questions.parcelDelivery;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class LogisticOrder {
	private String id;
	private Location pickupLocation;
	private Location deliveryLocation;
	private Parcel parcel;
	private BigDecimal totalCost;
	private BigDecimal totalDistance;
	private LocalDateTime pickupDate;
	private LocalDateTime deliveryDate;
	private DeliveryType deliveryType;
	private Status status;

	public LogisticOrder(CreateOrderRequest createOrderRequest) {
		this.id = UUID.randomUUID().toString().substring(0, 12);
		this.pickupLocation = createOrderRequest.getPickupLocation();
		this.deliveryLocation = createOrderRequest.getDeliveryLocation();
		this.parcel = createOrderRequest.getParcel();
		this.pickupDate = createOrderRequest.getPickupDate();
		this.deliveryType = createOrderRequest.getDeliveryType();
		this.status = Status.CREATED;
	}

}
