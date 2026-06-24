package org.example.questions.parcelDelivery;

public class SmsNotificationService implements NotificationService {
	@Override
	public void notifyCustomer(LogisticOrder logisticOrder, Status status) {
		System.out.println("Notifying customer for id = " + logisticOrder.getId() + " using sms service");
		System.out.println("Updated status to = " + status);
	}
}
