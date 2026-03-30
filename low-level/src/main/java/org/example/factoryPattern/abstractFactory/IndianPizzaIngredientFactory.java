package org.example.factoryPattern.abstractFactory;

import java.util.List;

public class IndianPizzaIngredientFactory implements PizzaIngredientFactory {
	@Override
	public String getCheese() {
		return "Mozzarella cheese";
	}

	@Override
	public String getCrust() {
		return "Thin";
	}

	@Override
	public String getSauce() {
		return "Tomato Sauce";
	}

	@Override
	public List<String> getToppings() {
		return List.of("Onion", "Tomato", "Capsicum");
	}
}
