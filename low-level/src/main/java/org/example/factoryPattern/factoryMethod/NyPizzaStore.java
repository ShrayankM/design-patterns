package org.example.factoryPattern.factoryMethod;

public class NyPizzaStore extends PizzaStore {
	@Override
	protected Pizza createPizza(String type) {
		if (type.equals("Cheese")) {
			return new NyCheesePizza();
		}
		return null;
	}
}
