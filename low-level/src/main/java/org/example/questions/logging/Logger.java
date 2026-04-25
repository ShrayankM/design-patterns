package org.example.questions.logging;

import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Logger {
	private final String name;
	private final Logger parent;
	private LogLevel currentLogLevel;
	private final List<LogAppender> logAppenderList = new ArrayList<>();
	private final ExecutorService executorService = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors());

	public Logger(String name, Logger parent) {
		this.name = name;
		this.parent = parent;
		this.currentLogLevel = LogLevel.DEBUG;
	}

	public void setCurrentLogLevel(LogLevel level) { this.currentLogLevel = level; }
	public void addLogAppender(LogAppender appender) { logAppenderList.add(appender); }

	public void debug(String message) { log(LogLevel.DEBUG, message); }
	public void info(String message)  { log(LogLevel.INFO, message); }
	public void warn(String message)  { log(LogLevel.WARN, message); }
	public void error(String message) { log(LogLevel.ERROR, message); }
	public void fatal(String message) { log(LogLevel.FATAL, message); }

	private void log(LogLevel level, String message) {
		if (level.ordinal() >= currentLogLevel.ordinal()) {
			Log logEntry = new Log(level, message, this.name);
			getEffectiveAppenders().stream()
					.filter(a -> a.isEnabled)
					.forEach(a -> executorService.submit(() -> a.appendLog(logEntry)));
		}
	}

	private List<LogAppender> getEffectiveAppenders() {
		return logAppenderList.isEmpty() && parent != null
				? parent.logAppenderList
				: logAppenderList;
	}

	public void shutdown() throws InterruptedException {
		executorService.shutdown();
		executorService.awaitTermination(5, TimeUnit.SECONDS);
	}
}
