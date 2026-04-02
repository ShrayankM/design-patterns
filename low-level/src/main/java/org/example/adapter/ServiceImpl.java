package org.example.adapter;

public class ServiceImpl implements Service {
	@Override
	public void receiveData(Integer data) {
		System.out.println("Receiving integer data " + data);
	}
}
