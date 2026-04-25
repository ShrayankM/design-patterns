package org.example.questions.logging;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class LoggerFactory {
	private static final Map<String, Logger> registry = new ConcurrentHashMap<>();
	private static final Logger rootLogger = new Logger("root", null);

	private LoggerFactory() {}

	public static Logger getRootLogger() {
		return rootLogger;
	}

	public static Logger getLogger(String name) {
		return registry.computeIfAbsent(name, n -> new Logger(n, rootLogger));
	}

	public static Logger getLogger(Class<?> clazz) {
		return getLogger(clazz.getName());
	}
}