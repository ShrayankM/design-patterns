package org.example.decoratorPattern.notifier;

public class EmailNotifier implements Notifier {
	private final String notifierDescription;

	public EmailNotifier() {
		this.notifierDescription = "Email-notifier";
	}

	@Override
	public void sendMessage() {
		System.out.println("Sending notification through " + notifierType());
	}

	@Override
	public String notifierType() {
		return this.notifierDescription;
	}
}
