package org.example.questions.library;

public interface BookUpdatePublisher {
	void addListeners(BookUpdateListener bookUpdateListener);
	void notifyListeners();
}
