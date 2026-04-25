package org.example.questions.logging;

public class FullLogFormatter implements LogFormatter {
	@Override
	public String format(Log log) {
		return "Id #" + log.getId() + " Timestamp = [" + log.getTimeStamp() + "], Message = {" + log.getMessage() + "}"
						+ "Type = " + log.getLogLevel() + " file " + log.getFilename();
	}
}
