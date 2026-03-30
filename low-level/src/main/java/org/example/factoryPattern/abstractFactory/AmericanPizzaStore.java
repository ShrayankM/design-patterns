package org.example.factoryPattern.abstractFactory;

public class AmericanPizzaStore extends PizzaStore {
	private final PizzaIngredientFactory ingredientFactory;

	public AmericanPizzaStore(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
	@Override
	Pizza createPizza(String type) {
		if ("cheese".equals(type)) {
			return new AmericanCheesePizza("American-cheese Pizza",
					this.ingredientFactory.getSauce(),
					this.ingredientFactory.getCrust(),
					this.ingredientFactory.getToppings()
			);
		}
		return null;
	}
}
