package org.example.questions.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookTitleSearch implements BookSearch, BookUpdateListener {
	private final BookInventoryManager bookInventoryManager;
	private Map<String, List<Book>> bookTitleMap;

	public BookTitleSearch(BookInventoryManager bookInventoryManager) {
		this.bookInventoryManager = bookInventoryManager;
		this.bookTitleMap = new HashMap<>();
		populateBookTitleMap();
	}

	@Override
	public List<Book> findBooks(Search search) {
		return bookTitleMap.get(search.getTitleSearch());
	}

	private void populateBookTitleMap() {
		List<Book> booksToSearch = this.bookInventoryManager.getAllBooks();
		bookTitleMap = booksToSearch.stream()
				.collect(Collectors.groupingBy(Book::getName));
	}

	@Override
	public void consumeBookUpdate(Book book) {
		String bookTitle = book.getName();
		List<Book> books =  bookTitleMap.getOrDefault(bookTitle, new ArrayList<>());
		books.add(book);
		bookTitleMap.put(bookTitle, books);
	}
}
