package org.example.questions.library;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BookReservationManager {
	private Map<String, Queue<User>> waitingUserPerBook;
	private NotificationService notificationService;

	public BookReservationManager(NotificationService notificationService) {
		this.waitingUserPerBook = new HashMap<>();
		this.notificationService = notificationService;
	}

	public void reserveBook(User user, Book book) {
		String bookId = book.getId();
		Queue<User> userList = waitingUserPerBook.getOrDefault(bookId, new LinkedList<>());
		userList.offer(user);
		this.waitingUserPerBook.put(bookId, userList);
	}

	public void bookAvailabilityUpdated(Book book) {
		String bookId = book.getId();
		Queue<User> userList = this.waitingUserPerBook.getOrDefault(bookId, new LinkedList<>());
		User userToNotify = userList.poll();
		this.notificationService.notifyUser(userToNotify, book);
	}
}
