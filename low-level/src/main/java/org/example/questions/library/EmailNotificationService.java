package org.example.questions.library;

public class EmailNotificationService implements NotificationService {
	@Override
	public void notifyUser(User user, Book book) {
		String email = user.getEmail();
		sendEmail(email, "Book is available" + book);
	}

	private void sendEmail(String emailAddress, String message) {
		System.out.println("Sending email to " + emailAddress + " with message = {" + message + "}");
	}
}
