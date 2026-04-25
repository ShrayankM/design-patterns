package org.example.questions.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookInventoryManager implements BookUpdatePublisher {
	private Map<String, Book> bookMap;
	private Map<String, List<BookCopy>> bookCopiesMap;
	private List<BookUpdateListener> bookUpdateListeners;
	private Book currentBookUpdated;

	public BookInventoryManager() {
		this.bookMap = new HashMap<>();
		this.bookCopiesMap = new HashMap<>();
		this.bookUpdateListeners = new ArrayList<>();
		this.currentBookUpdated = null;
	}

	public void addBook(Book book) {
		String bookId = book.getId();
		bookMap.put(bookId, book);
		List<BookCopy> copies = bookCopiesMap.getOrDefault(bookId, new ArrayList<>());
		copies.add(new BookCopy(book));
		bookCopiesMap.put(bookId, copies);
		this.currentBookUpdated = book;
		notifyListeners();
	}

	public BookCopy getAndReserveAvailableCopy(Book book) {
		return bookCopiesMap.getOrDefault(book.getId(), List.of())
				.stream()
				.filter(BookCopy::isAvailable)
				.findFirst()
				.map(copy -> { copy.setStatus(BookCopyStatus.ISSUED); return copy; })
				.orElse(null);
	}

	public void releaseCopy(BookCopy copy) {
		copy.setStatus(BookCopyStatus.AVAILABLE);
	}

	List<Book> getAllBooks() {
		return this.bookMap.values().stream().toList();
	}

	@Override
	public void addListeners(BookUpdateListener bookUpdateListener) {
		this.bookUpdateListeners.add(bookUpdateListener);
	}

	@Override
	public void notifyListeners() {
		this.bookUpdateListeners.forEach(bookUpdateListener ->
				bookUpdateListener.consumeBookUpdate(this.currentBookUpdated));
	}
}
