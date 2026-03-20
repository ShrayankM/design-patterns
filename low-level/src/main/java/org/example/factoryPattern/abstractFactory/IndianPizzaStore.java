package org.example.factoryPattern.abstractFactory;

import org.example.factoryPattern.factoryMethod.IndianPaneerPizza;
import org.example.factoryPattern.factoryMethod.Pizza;
import org.example.factoryPattern.factoryMethod.PizzaStore;

public class IndianPizzaStore extends PizzaStore {
	@Override
	protected Pizza createPizza(String type) {
		if (type.equals("Paneer")) {
			return new IndianPaneerPizza();
		}
		return null;
	}
}
