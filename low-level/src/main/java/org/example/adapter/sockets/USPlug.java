package org.example.adapter.sockets;

import lombok.Getter;

@Getter
public class USPlug {
	private final int noOfPins;
	private final int minVoltageSupported;

	public USPlug() {
		this.noOfPins = 2;
		this.minVoltageSupported = 110;
	}
}
