package org.example.factoryPattern.simpleFactory;

public class PizzaStore {
	private SimplePizzaFactory simplePizzaFactory;

	public PizzaStore(SimplePizzaFactory simplePizzaFactory) {
		this.simplePizzaFactory = simplePizzaFactory;
	}

	public Pizza orderPizza(String type) {
		Pizza pizza;

		pizza = simplePizzaFactory.createPizza(type);

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.pack();

		return pizza;
	}
}
