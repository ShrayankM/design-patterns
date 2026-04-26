package org.example.questions.notification;

import java.util.List;

public class MessageDemo {
	public static void main(String [] args) throws InterruptedException {
		MessageService messageService = new MessageService();

		Template orderTemplate = new OrderTemplate();
		User userShrayank = new User("shrayank", "shraymist@gmail.com", "8605511687");
		List<String> templateData = List.of(userShrayank.getName(), "189231");

		List<NotificationChannel> notificationChannelList = List.of(new Email(), new Sms());
		messageService.sendMessage(orderTemplate, templateData, MessagePriority.HIGH, userShrayank,
				notificationChannelList);

		Thread.sleep(1000); // wait for async processing

		messageService.viewMessageHistory();
	}
}
