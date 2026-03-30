package org.example.commandPattern.diner;

public class PizzaOrderCommand implements OrderCommand {
	private final Pizza pizza;

	public PizzaOrderCommand(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public void prepareOrder() {
		this.pizza.preparePizza();
	}
}
