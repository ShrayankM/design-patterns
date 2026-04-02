package org.example.adapter.sockets;

public class USToUKPlugAdapter extends UKPlug {
	private static final int pinParameter = 3;
	private static final int minVoltageParameter = 115;
	private USPlug usPlug;

	public USToUKPlugAdapter(USPlug usPlug) {
		this.usPlug = usPlug;
	}

	@Override
	public int getNoOfPins() {
		int extraPins = usPlug.getNoOfPins() - pinParameter;
		return usPlug.getNoOfPins() + (extraPins * -1);
	}

	@Override
	public int getMinVoltageSupported() {
		int extraVoltage = usPlug.getMinVoltageSupported() - minVoltageParameter;
		return usPlug.getMinVoltageSupported() + (extraVoltage * -1);
	}

}
