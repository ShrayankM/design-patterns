package org.example.questions.notification;

import java.util.Objects;

public class Sms implements NotificationChannel {
	@Override
	public boolean sendNotification(Message message) {
		System.out.println("Sending sms notification");
		return sendSms(message);
	}

	private boolean sendSms(Message message) {
		User user = message.getUser();
		String phoneNumber = user.getPhoneNumber();
		if (!Objects.isNull(phoneNumber)) {
			System.out.println("Sending sms to = " + phoneNumber + " for data = " +
					message.getData());
			return true;
		} else {
			System.out.println("Invalid phone number cannot send sms");
			return false;
		}
	}
}
