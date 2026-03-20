package org.example.decoratorPattern.notifier;

public class SlackNotifier extends ExtraNotifier {

	public SlackNotifier(Notifier notifier) {
		this.notifier = notifier;
	}

	@Override
	public void sendMessage() {
		System.out.println("Sending notification through " + notifierType());
		this.notifier.sendMessage();
	}

	@Override
	public String notifierType() {
		return "Slack Notifier";
	}
}
