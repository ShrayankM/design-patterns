package org.example.factoryPattern.abstractFactory;

import java.util.List;

public class AmericanCheesePizza extends Pizza {
	public AmericanCheesePizza(String name, String sauce, String crustType, List<String> toppings) {
		super(name, sauce, crustType, toppings);
	}
}
