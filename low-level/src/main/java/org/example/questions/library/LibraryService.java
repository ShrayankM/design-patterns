package org.example.questions.library;

import java.util.List;

public class LibraryService {
	private BookInventoryManager bookInventoryManager;
	private BookReservationManager bookReservationManager;
	private BookIssueManager bookIssueManager;

	public LibraryService(NotificationService notificationService, FineCalculator fineCalculator) {
		this.bookInventoryManager = new BookInventoryManager();
		this.bookReservationManager = new BookReservationManager(notificationService);
		this.bookIssueManager = new BookIssueManager(
				this.bookInventoryManager, this.bookReservationManager, fineCalculator);
	}

	public List<Book> searchBooks(Search search) {
		BookSearch bookSearch = getSearchStrategy(search);
		return bookSearch.findBooks(search);
	}

	public BookTicket issueBook(Book book, User user, int days) {
		return this.bookIssueManager.issueBook(book, user, days);
	}

	public void returnBook(BookTicket bookTicket) {
		this.bookIssueManager.returnBook(bookTicket);
	}

	public void reserveBook(User user, Book book) {
		this.bookReservationManager.reserveBook(user, book);
	}

	private BookSearch getSearchStrategy(Search search) {
		if (search.getTitleSearch() != null) {
			return new BookTitleSearch(this.bookInventoryManager);
		}

		if (search.getAuthorSearch() != null) {
			return new BookAuthorSearch(this.bookInventoryManager);
		}

		if (search.getGenreSearch() != null) {
			return new BookGenreSearch(this.bookInventoryManager);
		}
		return null;
	}
}
