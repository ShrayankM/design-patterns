package org.example.questions.library;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class BookIssueManager {
	private BookInventoryManager bookInventoryManager;
	private BookReservationManager bookReservationManager;
	private FineCalculator fineCalculator;

	public BookIssueManager(BookInventoryManager bookInventoryManager,
			BookReservationManager bookReservationManager,
			FineCalculator fineCalculator) {
		this.bookInventoryManager = bookInventoryManager;
		this.bookReservationManager = bookReservationManager;
		this.fineCalculator = fineCalculator;
	}

	public BookTicket issueBook(Book book, User user, int days) {
		BookCopy copy = this.bookInventoryManager.getAndReserveAvailableCopy(book);
		if (copy != null) {
			return new BookTicket(user, copy, days);
		} else {
			System.out.println("Book currently unavailable to issue, please reserve");
			bookReservationManager.reserveBook(user, book);
			return null;
		}
	}


	public void returnBook(BookTicket bookTicket) {
		if (bookTicket.getTicketStatus().equals(TicketStatus.RETURNED)) {
			System.out.println("Book is already returned, cannot return again");
			return;
		}

		BookCopy copy = bookTicket.getBookCopy();
		LocalDateTime returnDate = bookTicket.getReturnDate();
		if (LocalDateTime.now().isAfter(returnDate)) {
			int overDueDays = (int) ChronoUnit.DAYS.between(returnDate, LocalDateTime.now());
			BigDecimal fine = this.fineCalculator.calculateFine(overDueDays);
			System.out.println("Fine to be paid: " + fine);
		}
		this.bookInventoryManager.releaseCopy(copy);
		this.bookReservationManager.bookAvailabilityUpdated(copy.getBook());
		bookTicket.setTicketStatus(TicketStatus.RETURNED);
	}
}
