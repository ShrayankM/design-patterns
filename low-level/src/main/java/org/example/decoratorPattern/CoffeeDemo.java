package org.example.decoratorPattern;

public class CoffeeDemo {
	public static void main(String [] args) {
		Beverage darkRoastWithMochaAndSoy = new Soy(new Mocha(new DarkRoast()));
		System.out.println("Description = " + darkRoastWithMochaAndSoy.getDescription());
		System.out.println("Total cost = " + darkRoastWithMochaAndSoy.calculateCost());

		Beverage espressoWithSoyAndMocha = new Mocha(new Soy(new Espresso()));
		System.out.println("Description = " + espressoWithSoyAndMocha.getDescription());
		System.out.println("Total cost = " + espressoWithSoyAndMocha.calculateCost());
	}
}
