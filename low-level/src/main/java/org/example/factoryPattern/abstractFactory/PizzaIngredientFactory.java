package org.example.factoryPattern.abstractFactory;

import java.util.List;

public interface PizzaIngredientFactory {
	String getCheese();
	String getCrust();
	String getSauce();
	List<String> getToppings();
}
