package org.example.questions.logging;

public class BasicLogFormatter implements LogFormatter {
	@Override
	public String format(Log log) {
		return "Timestamp = [" + log.getTimeStamp() + "], Message = {" + log.getMessage() + "}";
	}
}
