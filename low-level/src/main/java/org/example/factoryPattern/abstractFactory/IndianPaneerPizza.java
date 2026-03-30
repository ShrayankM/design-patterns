package org.example.factoryPattern.abstractFactory;

import java.util.List;

public class IndianPaneerPizza extends Pizza {
	public IndianPaneerPizza(String name, String sauce, String crustType, List<String> toppings) {
		super(name, sauce, crustType, toppings);
	}
}
