package org.example.questions.library;

import lombok.Data;

@Data
public class Search {
	private String titleSearch;
	private Author authorSearch;
	private Genre genreSearch;

	public Search(String titleSearch, Author authorSearch, Genre genreSearch) {
		this.titleSearch = titleSearch;
		this.authorSearch = authorSearch;
		this.genreSearch = genreSearch;
	}
}
