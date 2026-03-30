package org.example.factoryPattern.abstractFactory;

import java.util.List;

public class AmericaPizzaIngredientFactory implements PizzaIngredientFactory {
	@Override
	public String getCheese() {
		return "new-york cheese";
	}

	@Override
	public String getCrust() {
		return "Thick";
	}

	@Override
	public String getSauce() {
		return "Tomato Barbeque sauce";
	}

	@Override
	public List<String> getToppings() {
		return List.of("onion", "chicken");
	}
}
