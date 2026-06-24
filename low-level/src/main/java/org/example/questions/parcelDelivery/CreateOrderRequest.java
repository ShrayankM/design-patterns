package org.example.questions.parcelDelivery;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateOrderRequest {
	private Parcel parcel;
	private Location pickupLocation;
	private Location deliveryLocation;
	private LocalDateTime pickupDate;
	private DeliveryType deliveryType;

	public CreateOrderRequest(Parcel parcel, Location pickupLocation, Location deliveryLocation, LocalDateTime pickupDate,
			DeliveryType deliveryType) {
		this.parcel = parcel;
		this.pickupLocation = pickupLocation;
		this.deliveryLocation = deliveryLocation;
		this.pickupDate = pickupDate;
		this.deliveryType = deliveryType;
	}
}
