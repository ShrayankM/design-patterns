package org.example.factoryPattern.abstractFactory;

public class PizzaDemo {
	public static void main(String [] args) {
		PizzaStore indianPizzaStore = new IndianPizzaStore(new IndianPizzaIngredientFactory());
		Pizza pizza = indianPizzaStore.orderPizza("paneer");
	}
}
