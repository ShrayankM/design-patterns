package org.example.factoryPattern.abstractFactory;

import org.example.factoryPattern.factoryMethod.Pizza;

public abstract class PizzaStore {

	public org.example.factoryPattern.factoryMethod.Pizza orderPizza(String type) {
		org.example.factoryPattern.factoryMethod.Pizza pizza;

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
