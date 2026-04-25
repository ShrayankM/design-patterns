package org.example.questions.logging;

public class LoggerDemo {
	public static void main(String[] args) throws InterruptedException {
		// One-time global setup at app startup
		Logger root = LoggerFactory.getRootLogger();
		root.addLogAppender(new ConsoleLogAppender(new FullLogFormatter()));
		root.addLogAppender(new FileLogAppender(new BasicLogFormatter(), "app.log"));
		root.setCurrentLogLevel(LogLevel.INFO);

		// Any class in the app — no config needed, inherits from root
		Logger orderLogger = LoggerFactory.getLogger(LoggerDemo.class);
		orderLogger.info("Order placed");   // uses root's appenders
		orderLogger.debug("debug skipped"); // filtered — level is INFO

		// Override locally for a specific logger
		Logger auditLogger = LoggerFactory.getLogger(LoggerDemo.class);
		auditLogger.addLogAppender(new DBLogAppender(new FullLogFormatter()));
		auditLogger.info("Audit event");    // uses its own DBLogAppender only

		root.shutdown();
	}
}
