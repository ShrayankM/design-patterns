package org.example.questions.logging;

public class LoggerDemo {
	public static void main(String[] args) throws InterruptedException {
		Logger loggerDemo = LoggerFactory.getLogger(LoggerDemo.class);
		// configure once
		loggerDemo.addLogAppender(new ConsoleLogAppender(new FullLogFormatter()));
		loggerDemo.setCurrentLogLevel(LogLevel.INFO);

		// anywhere else in the app — same instance returned
		Logger sameLogger = LoggerFactory.getLogger(LoggerDemo.class);
		sameLogger.info("reused logger");

		LogFormatter logFormatter = new FullLogFormatter();
		FileLogAppender fileLogAppender = new FileLogAppender(logFormatter, "logFile.txt");
		fileLogAppender.disableLogAppender();
		fileLogAppender.enabledLogAppender();
		loggerDemo.addLogAppender(fileLogAppender);
		loggerDemo.addLogAppender(new ConsoleLogAppender(logFormatter));
		loggerDemo.setCurrentLogLevel(LogLevel.INFO);

		loggerDemo.debug("debug-log");
		loggerDemo.info("info-log");
		loggerDemo.error("error-log");

		loggerDemo.shutdown(); // <-- needed
	}
}
