package org.example.commandPattern.diner;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private final List<OrderCommand> orderCommandList;

	public Order() {
		this.orderCommandList = new ArrayList<>();
	}

	public void addItemToOrder(OrderCommand orderCommand) {
		this.orderCommandList.add(orderCommand);
	}

	public void createOrder() {
		orderCommandList.forEach(OrderCommand::prepareOrder);
	}
}
