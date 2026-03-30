package org.example.factoryPattern.abstractFactory;


public class IndianPizzaStore extends PizzaStore {
	private final PizzaIngredientFactory ingredientFactory;

	public IndianPizzaStore(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	@Override
	Pizza createPizza(String type) {
		if ("paneer".equals(type)) {
			return new IndianPaneerPizza("Indian Paneer pizza",
					this.ingredientFactory.getSauce(),
					this.ingredientFactory.getCrust(),
					this.ingredientFactory.getToppings()
			);
		}
		return null;
	}
}
