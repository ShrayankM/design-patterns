package org.example.adapter;

public class ServiceAdapter implements Client {
	private final Service service;

	public ServiceAdapter(Service service) {
		this.service = service;
	}

	@Override
	public void sendData(String data) {
		service.receiveData(Integer.valueOf(data));
	}
}
