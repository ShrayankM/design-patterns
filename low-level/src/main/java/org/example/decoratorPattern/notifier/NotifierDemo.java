package org.example.decoratorPattern.notifier;

public class NotifierDemo {
	public static void main(String [] args) {
		Notifier notifier = new SmsNotifier(new SlackNotifier(new EmailNotifier()));
		notifier.sendMessage();
	}
}
