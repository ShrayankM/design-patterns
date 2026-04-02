package org.example.adapter.sockets;

public class UKSocket {
	private static final int pinParameter = 3;
	private static final int minVoltageParameter = 115;

	public void plugInToSocket(UKPlug plug) {
		if (plug.getNoOfPins() == pinParameter && plug.getMinVoltageSupported() >= minVoltageParameter) {
			System.out.println("Plug inserted in socket successfully, delivering power");
		}
	}
}
