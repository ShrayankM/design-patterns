package org.example.factoryPattern.factoryMethod;

public abstract class PizzaStore {

	public Pizza orderPizza(String type) {
		Pizza pizza;

		pizza = createPizza(type);

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.pack();

		return pizza;
	}

	// factory method
	protected abstract Pizza createPizza(String type);
}
