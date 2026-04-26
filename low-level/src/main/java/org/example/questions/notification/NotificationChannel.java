package org.example.questions.notification;

public interface NotificationChannel {
	boolean sendNotification(Message message);
	String viewNotificationChannel();
}
