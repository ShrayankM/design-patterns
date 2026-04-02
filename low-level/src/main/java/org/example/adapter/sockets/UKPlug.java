package org.example.adapter.sockets;

import lombok.Getter;

@Getter
public class UKPlug {
	private final int noOfPins;
	private final int minVoltageSupported;

	public UKPlug() {
		this.noOfPins = 3;
		this.minVoltageSupported = 115;
	}
}
