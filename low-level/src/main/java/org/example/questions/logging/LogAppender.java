package org.example.questions.logging;

public abstract class LogAppender {
//	protected LogFormatType logFormatType;
	protected LogFormatter logFormatter;
	protected boolean isEnabled;
	abstract protected void appendLog(Log log);

	public LogAppender(LogFormatter logFormatter) {
		this.logFormatter = logFormatter;
		this.isEnabled = true;
	}

//	String returnBasicLogFormat(Log log) {
//		return "Timestamp = [" + log.getTimeStamp() + "], Message = {" + log.getMessage() + "}";
//	}
//
//	String returnFullLogFormat(Log log) {
//		return "Id #" + log.getId() + " Timestamp = [" + log.getTimeStamp() + "], Message = {" + log.getMessage() + "}"
//				+ "Type = " + log.getLogLevel() + " file " + log.getFilename();
//	}

	public void disableLogAppender() {
		this.isEnabled = false;
	}

	public void enabledLogAppender() {
		this.isEnabled = true;
	}
}
