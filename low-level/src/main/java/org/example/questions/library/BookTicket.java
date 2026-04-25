package org.example.questions.library;

import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
public class BookTicket {
	private LocalDateTime issueDate;
	private LocalDateTime returnDate;
	private User user;
	private BookCopy bookCopy;
	private TicketStatus ticketStatus;

	public BookTicket(User user, BookCopy bookCopy, int days) {
		this.issueDate = LocalDateTime.now();
		this.returnDate = LocalDateTime.now().plus(Duration.ofDays(days));
		this.user = user;
		this.bookCopy = bookCopy;
		this.ticketStatus = TicketStatus.ACTIVE;
	}
}
