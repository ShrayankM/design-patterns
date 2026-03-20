package org.example.factoryPattern.factoryMethod;

public class IndianPizzaStore extends PizzaStore {
	@Override
	protected Pizza createPizza(String type) {
		if (type.equals("Paneer")) {
			return new IndianPaneerPizza();
		}
		return null;
	}
}
