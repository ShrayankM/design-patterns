package org.example.adapter;

public class AdapterDemo {
	public static void main(String [] args) {
		Client a = new ClientImpl();
		Service b = new ServiceImpl();

		ServiceAdapter serviceAdapter = new ServiceAdapter(b);
		a.sendData("1");

		serviceAdapter.sendData("2");
	}
}
