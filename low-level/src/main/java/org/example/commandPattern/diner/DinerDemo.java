package org.example.commandPattern.diner;

public class DinerDemo {
	public static void main(String [] args) {
		Order order = new Order();

		Pizza pizza = new Pizza();
		order.addItemToOrder(new PizzaOrderCommand(pizza));

		Burger burger = new Burger();
		order.addItemToOrder(new BugerOrderCommand(burger));

		order.createOrder();
	}
}
