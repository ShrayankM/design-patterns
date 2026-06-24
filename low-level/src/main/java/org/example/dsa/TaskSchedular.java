package org.example.dsa;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskSchedular {
	public static class TaskData {
		int identifier;
		int frequency;
		int waitingTime;

		TaskData(int identifier, int frequency) {
			this.identifier = identifier;
			this.frequency = frequency;
			this.waitingTime = 0;
		}
	}

	public int leastInterval(char[] tasks, int n) {
		int [] frequency = new int[26];

		for (int i = 0; i < tasks.length; i++) {
			char identifier = tasks[i];
			frequency[identifier - 'A']++;
		}

		PriorityQueue<TaskData> scheduledQueue = new PriorityQueue<>((a, b) ->
				Integer.compare(b.frequency, a.frequency)
		);
		Queue<TaskData> waitingQueue = new LinkedList<>();

		for (int i = 0; i < 26; i++) {
			if (frequency[i] > 0) scheduledQueue.offer(new TaskData(i, frequency[i]));
		}

		int time = 0;
		while (!scheduledQueue.isEmpty() || !waitingQueue.isEmpty()) {
			time++;

			Queue<TaskData> tempWaiting = new LinkedList<>();
			while (!waitingQueue.isEmpty()) {
				TaskData waitingTask = waitingQueue.poll();
				if (waitingTask.waitingTime < time) {
					scheduledQueue.offer(waitingTask);
				} else {
					tempWaiting.add(waitingTask);
				}
			}

			waitingQueue = tempWaiting;

			if (scheduledQueue.isEmpty()) continue;

			TaskData currentTask = scheduledQueue.poll();
			if (currentTask.frequency == 1) continue;

			currentTask.frequency--;
			currentTask.waitingTime = time + n;
			waitingQueue.add(currentTask);
		}
		return time;
	}
}
