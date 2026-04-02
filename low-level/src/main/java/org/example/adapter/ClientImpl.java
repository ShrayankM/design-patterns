package org.example.adapter;

public class ClientImpl implements Client {
	@Override
	public void sendData(String data) {
		System.out.println("Sending string data = {" + data + "}");
	}
}
