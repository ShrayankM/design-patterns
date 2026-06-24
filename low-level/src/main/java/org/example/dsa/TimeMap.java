package org.example.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {
	public static class TimeStampData {
		private int timestamp;
		private String value;

		public TimeStampData(int timestamp, String value) {
			this.timestamp = timestamp;
			this.value = value;
		}
	}

	private Map<String, List<TimeStampData>> timestampMap;

	public TimeMap() {
		this.timestampMap = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		TimeStampData timeStampData = new TimeStampData(timestamp, value);
		List<TimeStampData> timeStampDataList = new ArrayList<>();

		if (this.timestampMap.containsKey(key)) {
			 timeStampDataList = timestampMap.get(key);
			timeStampDataList.add(timeStampData);
		} else {
			timeStampDataList.add(timeStampData);
			this.timestampMap.put(key, timeStampDataList);
		}
	}

	public String get(String key, int timestamp) {
		if (this.timestampMap.containsKey(key)) {
			List<TimeStampData> timeStampDataList = this.timestampMap.get(key);

			int i = 0, j = timeStampDataList.size() - 1;
			while (i < j) {
				int mid = i + (j - i) / 2;

				TimeStampData timeStampData = timeStampDataList.get(mid);
				if (timeStampData.timestamp == timestamp) return timeStampData.value;

				if (timeStampData.timestamp > timestamp) j = mid - 1;
				else i = mid + 1;
			}
			TimeStampData candidate = timeStampDataList.get(i);
			if (candidate.timestamp <= timestamp) return candidate.value;
			return i > 0 ? timeStampDataList.get(i - 1).value : "";
		}
		return null;
	}
}

