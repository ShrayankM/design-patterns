package org.example.factoryPattern.abstractFactory;

import java.util.List;

public abstract class Pizza {
	private final String name;
	private final String sauce;
	private final String crustType;
	private final List<String> toppings;

	public Pizza(String name, String sauce, String crustType, List<String> toppings) {
		this.name = name;
		this.sauce = sauce;
		this.crustType = crustType;
		this.toppings = toppings;
	}

	public void prepare() {
		System.out.println("Preparing " + name + " pizza ");
		System.out.println("Creating crust of type = " + this.crustType);
		System.out.println("Adding sauce = " + this.sauce);

		if(!toppings.isEmpty()) {
			System.out.println("Adding toppings = {" + this.toppings + "}");
		}
	}

	public void bake() {
		System.out.println("Baking for 15 mins");
	}

	public void cut() {
		System.out.println("Cutting into 6 slices");
	}

	public void pack() {
		System.out.println("Packing in pizza box");
	}
}

