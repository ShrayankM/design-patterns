package org.example.shippingLocker;

public class SmsNotificationService implements NotificationService {
	@Override
	public void sendNotification(String message, Account user) {
		System.out.println("Sending notification via SMS to user = " + user.getId());
		System.out.println("Message = {" + message + "}");
	}
}
