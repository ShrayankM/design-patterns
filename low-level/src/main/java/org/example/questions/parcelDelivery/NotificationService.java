package org.example.questions.parcelDelivery;

public interface NotificationService {
	void notifyCustomer(LogisticOrder logisticOrder, Status newStatus);
}
