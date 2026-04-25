package org.example.questions.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookAuthorSearch implements BookSearch, BookUpdateListener {
	private final BookInventoryManager bookInventoryManager;
	private Map<Author, List<Book>> bookAuthorMap;

	public BookAuthorSearch(BookInventoryManager bookInventoryManager) {
		this.bookInventoryManager = bookInventoryManager;
		this.bookAuthorMap = new HashMap<>();
		populateBookAuthorMap();
	}

	@Override
	public List<Book> findBooks(Search search) {
		return bookAuthorMap.get(search.getAuthorSearch());
	}

	private void populateBookAuthorMap() {
		List<Book> booksToSearch = this.bookInventoryManager.getAllBooks();
		bookAuthorMap = booksToSearch.stream()
				.collect(Collectors.groupingBy(Book::getAuthor));
	}

	@Override
	public void consumeBookUpdate(Book book) {
		Author bookAuthor = book.getAuthor();
		List<Book> books =  bookAuthorMap.getOrDefault(bookAuthor, new ArrayList<>());
		books.add(book);
		bookAuthorMap.put(bookAuthor, books);
	}
}
