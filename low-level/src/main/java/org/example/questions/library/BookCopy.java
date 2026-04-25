package org.example.questions.library;

import lombok.Data;
import java.util.UUID;

@Data
public class BookCopy {
	private String copyId;
	private Book book;
	private BookCopyStatus status;

	public BookCopy(Book book) {
		this.copyId = UUID.randomUUID().toString();
		this.book = book;
		this.status = BookCopyStatus.AVAILABLE;
	}

	public boolean isAvailable() {
		return this.status == BookCopyStatus.AVAILABLE;
	}
}