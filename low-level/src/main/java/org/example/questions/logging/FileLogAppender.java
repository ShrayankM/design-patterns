package org.example.questions.logging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogAppender extends LogAppender {
	private File logFile;

	public FileLogAppender(LogFormatter logFormatter, String filePath) {
		super(logFormatter);
		this.logFile = new File(filePath);
	}

	@Override
	protected synchronized void appendLog(Log log) {
		String formattedLog = logFormatter.format(log);
		try (FileWriter writer = new FileWriter(logFile, true)) {
			writer.write(formattedLog + System.lineSeparator());
		} catch (IOException e) {
			System.err.println("Failed to write log to file: " + e.getMessage());
		}
	}
}