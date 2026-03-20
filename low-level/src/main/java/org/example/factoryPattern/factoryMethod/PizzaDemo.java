package org.example.factoryPattern.factoryMethod;

public class PizzaDemo {
	public static void main(String [] args) {
		PizzaStore nyPizzaStore = new NyPizzaStore();
		Pizza nyCheesePizza = nyPizzaStore.orderPizza("Cheese");

		PizzaStore indianPizzaStore = new IndianPizzaStore();
		Pizza indianPaneerPizza = indianPizzaStore.orderPizza("Paneer");
	}
}
