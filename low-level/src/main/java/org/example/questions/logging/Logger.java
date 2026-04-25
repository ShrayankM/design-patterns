package org.example.questions.logging;

import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Logger {
	@Setter
	private LogLevel currentLogLevel;
	private List<LogAppender> logAppenderList;
	private String filename;

	// Add field:
	private final ExecutorService executorService = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors());

	public Logger(String filename) {
		this.currentLogLevel = LogLevel.DEBUG;
		this.logAppenderList = new ArrayList<>();
		this.filename = filename;
	}

	public void addLogAppender(LogAppender logAppender) {
		this.logAppenderList.add(logAppender);
	}

	public void info(String message) {
		if (LogLevel.INFO.ordinal() >= currentLogLevel.ordinal()) {
			Log log = new Log(LogLevel.INFO, message, this.filename);
			logAppenderList.forEach(logAppender -> {
				if (logAppender.isEnabled) {
					sendLog(log, logAppender);
				}
			});
		}
	}

	public void debug(String message) {
		if (LogLevel.DEBUG.ordinal() == currentLogLevel.ordinal()) {
			Log log = new Log(LogLevel.DEBUG, message, this.filename);
			logAppenderList.forEach(logAppender -> {
				if (logAppender.isEnabled) {
					sendLog(log, logAppender);
				}
			});
		}
	}

	public void warn(String message) {
		if (LogLevel.WARN.ordinal() >= currentLogLevel.ordinal()) {
			Log log = new Log(LogLevel.WARN, message, this.filename);
			logAppenderList.forEach(logAppender -> {
				if (logAppender.isEnabled) {
					sendLog(log, logAppender);
				}
			});
		}
	}

	public void error(String message) {
		if (LogLevel.ERROR.ordinal() >= currentLogLevel.ordinal()) {
			Log log = new Log(LogLevel.ERROR, message, this.filename);
			logAppenderList.forEach(logAppender -> {
				if (logAppender.isEnabled) {
					sendLog(log, logAppender);
				}
			});
		}
	}

//	public void createLog(LogLevel logLevel, String message, String filename) {
//		if (logLevel.ordinal() >= currentLogLevel.ordinal()) {
//			Log log = new Log(logLevel, message, filename);
//			logAppenderList.forEach(logAppender -> {
//				if (logAppender.isEnabled) {
//					sendLog(log, logAppender);
//				}
//			});
//		}
//	}

	// Change sendLog to:
	private void sendLog(Log log, LogAppender logAppender) {
		executorService.submit(() -> logAppender.appendLog(log));
	}

	public void shutdown() throws InterruptedException {
		executorService.shutdown();
		executorService.awaitTermination(5, TimeUnit.SECONDS);
	}
}
