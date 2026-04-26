package org.example.questions.notification;

import java.util.Objects;

public class Email implements NotificationChannel {
	@Override
	public boolean sendNotification(Message message) {
		System.out.println("Sending email notification");
		return sendEmail(message);
	}

	private boolean sendEmail(Message message) {
		User user = message.getUser();
		String emailAddress = user.getEmailAddress();
		if (!Objects.isNull(emailAddress)) {
			System.out.println("Sending email to = " + emailAddress + " for data = " +
					message.getData());
			return true;
		} else {
			System.out.println("Invalid email address cannot send email");
			return false;
		}
	}
}
