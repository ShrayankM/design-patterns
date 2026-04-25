package org.example.questions.logging;

import java.util.ArrayList;
import java.util.List;

public class DBLogAppender extends LogAppender {
	private List<String> dbLog;

	public DBLogAppender(LogFormatter logFormatter) {
		super(logFormatter);
		this.dbLog = new ArrayList<>();
	}

	@Override
	protected synchronized void appendLog(Log log) {
		String formattedLog = logFormatter.format(log);
		dbLog.add(formattedLog);
	}
}
