package org.example.commandPattern;

public class RemoteControlTest {
	public static void main(String [] args) {
		SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
		Light livingRoomLight = new Light();
		GarageDoor garageDoor = new GarageDoor();

		LightOnCommand lightOn = new LightOnCommand(livingRoomLight);
		simpleRemoteControl.setCommand(lightOn);
		simpleRemoteControl.buttonPressed();

		GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
		simpleRemoteControl.setCommand(garageDoorOpenCommand);
		simpleRemoteControl.buttonPressed();
	}
}
