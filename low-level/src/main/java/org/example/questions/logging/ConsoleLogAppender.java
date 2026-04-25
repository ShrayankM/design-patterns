package org.example.questions.logging;

public class ConsoleLogAppender extends LogAppender {
	public ConsoleLogAppender(LogFormatter logFormatter) {
		super(logFormatter);
	}

	@Override
	public synchronized void appendLog(Log log) {
		String formattedLog = logFormatter.format(log);
		System.out.println(formattedLog);
	}
}
