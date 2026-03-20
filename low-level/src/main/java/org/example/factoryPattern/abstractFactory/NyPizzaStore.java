package org.example.factoryPattern.abstractFactory;

import org.example.factoryPattern.factoryMethod.NyCheesePizza;
import org.example.factoryPattern.factoryMethod.Pizza;
import org.example.factoryPattern.factoryMethod.PizzaStore;

public class NyPizzaStore extends PizzaStore {
	@Override
	protected Pizza createPizza(String type) {
		if (type.equals("Cheese")) {
			return new NyCheesePizza();
		}
		return null;
	}
}
