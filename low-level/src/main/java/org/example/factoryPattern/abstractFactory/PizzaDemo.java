package org.example.factoryPattern.abstractFactory;

import org.example.factoryPattern.factoryMethod.IndianPizzaStore;
import org.example.factoryPattern.factoryMethod.NyPizzaStore;
import org.example.factoryPattern.factoryMethod.Pizza;
import org.example.factoryPattern.factoryMethod.PizzaStore;

public class PizzaDemo {
	public static void main(String [] args) {
		org.example.factoryPattern.factoryMethod.PizzaStore nyPizzaStore = new NyPizzaStore();
		org.example.factoryPattern.factoryMethod.Pizza nyCheesePizza = nyPizzaStore.orderPizza("Cheese");

		PizzaStore indianPizzaStore = new IndianPizzaStore();
		Pizza indianPaneerPizza = indianPizzaStore.orderPizza("Paneer");
	}
}
