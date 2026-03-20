package org.example.decoratorPattern.notifier;

public class SmsNotifier extends ExtraNotifier {
	public SmsNotifier(Notifier notifier) {
		this.notifier = notifier;
	}

	@Override
	public void sendMessage() {
		System.out.println("Sending notification through " + notifierType());
		this.notifier.sendMessage();
	}

	@Override
	public String notifierType() {
		return "Sms notifier";
	}
}
