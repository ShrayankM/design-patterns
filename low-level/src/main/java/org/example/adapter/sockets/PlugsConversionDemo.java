package org.example.adapter.sockets;

public class PlugsConversionDemo {
	public static void main(String [] args) {
		UKSocket ukSocket = new UKSocket();

		USPlug usPlug = new USPlug();
		USToUKPlugAdapter adapter = new USToUKPlugAdapter(usPlug);

		ukSocket.plugInToSocket(adapter);
	}
}
