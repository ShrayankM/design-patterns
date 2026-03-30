package org.example.factoryPattern.abstractFactory;

public abstract class PizzaStore {
	Pizza orderPizza(String type) {
		Pizza pizza = createPizza(type);

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.pack();

		return pizza;
	}

	abstract Pizza createPizza(String type);
}
