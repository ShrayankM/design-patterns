package org.example.questions.logging;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Log {
	private String id;
	private LocalDateTime timeStamp;
	private LogLevel logLevel;
	private String message;
	private String filename;

	public Log(LogLevel logLevel, String message, String filename) {
		this.id = UUID.randomUUID().toString();
		this.timeStamp = LocalDateTime.now();
		this.logLevel = logLevel;
		this.message = message;
		this.filename = filename;
	}

	@Override
	public String toString() {
		return timeStamp + " type = [" + logLevel + "] " + "{" + message + "}";
	}
}
