package org.example.templatePattern;

public abstract class Beverage {
	public void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}

	void boilWater() {
		System.out.println("Put the water to boil");
	}

	void pourInCup() {
		System.out.println("Pour the beverage in a cup");
	}

	abstract void brew();
	abstract void addCondiments();
}
