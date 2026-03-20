package org.example.factoryPattern.simpleFactory;

public class SimplePizzaFactory {

	public Pizza createPizza(String type) {
		Pizza pizza;
		if (type.equals("Cheese")) {
			pizza = new CheesePizza();
		} else {
			pizza = new PlainPizza();
		}
		return pizza;
	}
}
