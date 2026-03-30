package org.example.commandPattern;

public class SimpleRemoteControl {
	private Command slot;

	public void setCommand(Command command) {
		this.slot = command;
	}

	public void buttonPressed() {
		this.slot.execute();
	}
}
