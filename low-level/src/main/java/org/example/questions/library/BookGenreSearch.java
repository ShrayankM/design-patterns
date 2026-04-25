package org.example.questions.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookGenreSearch implements BookSearch, BookUpdateListener {
	private final BookInventoryManager bookInventoryManager;
	private Map<Genre, List<Book>> bookGenreMap;

	public BookGenreSearch(BookInventoryManager bookInventoryManager) {
		this.bookInventoryManager = bookInventoryManager;
		this.bookGenreMap = new HashMap<>();
		populateBookGenreMap();
	}

	@Override
	public List<Book> findBooks(Search search) {
		return bookGenreMap.get(search.getGenreSearch());
	}

	private void populateBookGenreMap() {
		List<Book> booksToSearch = this.bookInventoryManager.getAllBooks();
		bookGenreMap = booksToSearch.stream()
				.collect(Collectors.groupingBy(Book::getGenre));
	}

	@Override
	public void consumeBookUpdate(Book book) {
		Genre bookGenre = book.getGenre();
		List<Book> books =  bookGenreMap.getOrDefault(bookGenre, new ArrayList<>());
		books.add(book);
		bookGenreMap.put(bookGenre, books);
	}
}
